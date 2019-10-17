package hibernate.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {


	private FileOutputStream fos;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody Object handleFileUpload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
		Map map = new HashMap<>();
		String baseFolder = "c:\\temp\\"; 
		 String folder = request.getParameter("folder");
		 String filename = request.getParameter("filename");
		if (multipartFile.isEmpty()) {
			return "fail";
		}
		String message = "success";
		try {
			byte fileData[] = multipartFile.getBytes();
			new File(baseFolder + folder).mkdirs();
			if(StringUtils.hasText(filename)){
				fos = new FileOutputStream(baseFolder + folder +"//"+ filename);
			}else{
				fos = new FileOutputStream(baseFolder + folder +"//"+ multipartFile.getOriginalFilename());
				map.put("resultFile", multipartFile.getOriginalFilename());
			}
			fos.write(fileData);
		} catch (Exception e) {
			message = "fail";
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}
			}
		}
		map.put(message, "true");
		return map;
	}
}