package com.church.library.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/file")
public class FileController {

	private static Logger log = Logger.getLogger(BookController.class);
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String index(){
		return "admin/upload";
	}
	
	/**
	 * 上传文件
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(MultipartFile file) throws IOException{
		if(file.isEmpty()){
			
		}
		log.debug("Process file:{}" + file.getOriginalFilename());
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/home/philip/dev/testUp", System.currentTimeMillis()+file.getOriginalFilename()));
		return "success";
		
	}
	
	/**
	 * 下载文件
	 */
	public void download(){
		
	}
}
