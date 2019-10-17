package com.barclayswealth.fsvoc.presentation;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Web optimization tools recommend using compression to minimize payloads when sending content over HTTP. A common
 * technique employed by Java developers is to install a ServletFilter to compress all outgoing files. While this
 * technique may work well for dynamically generated content, it is very CPU-inefficient for static content.
 *
 * This servlet is designed to serve static resources that have been precompressed during the build process. If you are
 * using Maven, the yuicompressor-maven-plugin plugin can gzip javascript files while minifying them. Another option is
 * to use ant and the gzip task.
 *
 * The servlet kicks in when the following criteria are fulfilled:
 * <ul>
 * <li>The incoming http request is a GET</li>
 * <li>The requested file name ends with .js or .css</li>
 * <li>The Accept-Encoding header includes 'gzip'</li>
 * <li>A file with a matching name and the suffix '.gz' exists in the same directory as the file being requested.</li>
 * </ul>
 *
 * If this is the case, the request is forwarded to the default dispatcher for the '.gz' file. If this is not the case,
 * the original request is forwarded to the default dispatcher.
 *
 * In either case the default servlet container dispatcher transmits the file, ensuring the any optimisations that are
 * used for effiecent file transfer are maintained.
 *
 * @author Andrew Newdigate
 */
public class PrecompressedStaticServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private RequestDispatcher defaultServlet;

    @Override
    public void init() throws ServletException {
        super.init();

        defaultServlet = getServletContext().getNamedDispatcher("default");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (requestIsElligibleForCompressedSend(request)) {
            String gzPath = getRelativePath(request) + ".gz";
            String mimeType = getMimeType(request);

            response.setContentType(mimeType);
            response.setHeader("Content-Encoding", "gzip");
            response.setHeader("Vary", "Accept-Encoding");

            request.getRequestDispatcher(gzPath)
            .forward(request, responseWrapper(response, "Content-Type", "Content-Encoding", "Vary"));

        } else {
            defaultServlet.forward(request, response);
        }
    }

    private boolean requestIsElligibleForCompressedSend(HttpServletRequest request) throws MalformedURLException {
        if (!matchingExtension(request.getRequestURI())) {
            return false;
        }

        String acceptEncoding = request.getHeader("Accept-Encoding");
        if (acceptEncoding == null) {
            return false;
        }

        if (!acceptEncoding.contains("gzip")) {
            return false;
        }

        String gzPath = getRelativePath(request) + ".gz";
        URL compressedUrl = getServletContext().getResource(gzPath);

        return compressedUrl != null;
    }

    protected String getMimeType(HttpServletRequest request) {
        String mimeType = getServletContext().getMimeType(request.getRequestURI());

        return mimeType;
    }

    protected String getRelativePath(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        if (contextPath == null || contextPath.isEmpty()) {
            return requestUri;
        }

        String relativeToContext = requestUri.substring(contextPath.length());
        return relativeToContext;
    }

    protected boolean matchingExtension(String requestUri) {
        return requestUri.endsWith(".js") || requestUri.endsWith(".css");
    }

    protected HttpServletResponse responseWrapper(HttpServletResponse response, final String... headersToIgnore) {
        final Set<String> headers = new HashSet<String>(Arrays.asList(headersToIgnore));

        return new HttpServletResponseWrapper(response) {

            @Override
            public void setHeader(String name, String value) {
                if (headers.contains(name)) {
                    return;
                }
                super.setHeader(name, value);
            }

            @Override
            public void setDateHeader(String name, long date) {
                if (headers.contains(name)) {
                    return;
                }

                super.setDateHeader(name, date);
            }

            @Override
            public void setIntHeader(String name, int value) {
                if (headers.contains(name)) {
                    return;
                }

                super.setIntHeader(name, value);
            }

            @Override
            public void addDateHeader(String name, long date) {
                if (headers.contains(name)) {
                    return;
                }

                super.addDateHeader(name, date);
            }

            @Override
            public void addHeader(String name, String value) {
                if (headers.contains(name)) {
                    return;
                }

                super.addHeader(name, value);
            }

            @Override
            public void addIntHeader(String name, int value) {
                if (headers.contains(name)) {
                    return;
                }

                super.addIntHeader(name, value);
            }

            @Override
            public void setContentType(String type) {
                if (headers.contains("Content-Type")) {
                    return;
                }

                super.setContentType(type);
            }

        };
    }

}