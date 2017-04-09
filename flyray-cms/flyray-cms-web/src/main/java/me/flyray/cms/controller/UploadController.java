package me.flyray.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.flyray.cms.dao.PhotoFileDao;
import me.flyray.cms.model.PhotoFile;
import me.flyray.cms.service.QiniuCloudServiceImpl;
import me.flyray.cms.util.Base64Util;
import me.flyray.cms.util.BeanUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/** 
* @author: bolei
* @date：2017年4月2日 上午9:45:04 
* @description：图片上传
*/

@Controller
public class UploadController {
	
	@Autowired
	private QiniuCloudServiceImpl qiniuCloudService;
	
	@Autowired
	private PhotoFileDao photoFileDao;
	
	@RequestMapping(value="/upload", method = RequestMethod.GET)
	public String index(){ 
		return "upload";
	}
	
	@RequestMapping("/uploadToCloud"  )  
    public String uploadToCloud(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
        //创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){
                	//获取文件的byte 数组
                	byte[] data = Base64Util.toBase64(file.getInputStream());
                	qiniuCloudService.upload(data);
                }  
            }  
        }  
        return "/success";  
    }
}
