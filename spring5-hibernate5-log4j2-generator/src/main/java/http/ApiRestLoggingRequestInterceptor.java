package http;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;

import hibernate.model.HttpRestLog;
import hibernate.service.HttpService;

/**
 * api for logging
 */
public class ApiRestLoggingRequestInterceptor implements ClientHttpRequestInterceptor {

	private static final Logger requestLog = LogManager.getLogger("request");
	private static final Logger responseLog = LogManager.getLogger("response");

	
	@Autowired HttpService service;
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		ClientHttpResponse response = execution.execute(request, body);
		log(request, body, response);
		return response;
	}

	private void log(HttpRequest request, byte[] body, ClientHttpResponse response) throws IOException {
		if (requestLog.isInfoEnabled()) {
//			HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();;
//			HttpSession session = req.getSession(true);
//			System.out.println(session.getId());
			requestLog.info(request.getURI().toString() + " - " + new String(body));
			service.insert(new HttpRestLog(requestLog.getName(),request.getMethodValue(),request.getURI().toString(), new String(body)));
		}
		if (responseLog.isInfoEnabled()) {
			responseLog.info(request.getURI().toString() + " - " + new String(FileCopyUtils.copyToByteArray(response.getBody())));
			service.insert(new HttpRestLog(responseLog.getName(),request.getMethodValue(),request.getURI().toString(), new String(FileCopyUtils.copyToByteArray(response.getBody()))));
		}
	}
}