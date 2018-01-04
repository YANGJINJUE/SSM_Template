package com.tgb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("admin")
public class UploadController {

    /**
     * 管理员初始化主页
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request, ModelMap map) {
        // 将request变成多部分request
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter = multiRequest.getFileNames();

        MultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = multipartResolver.resolveMultipart(request);


        if (multipartResolver.isMultipart(request)) {
            while (iter.hasNext()) {
                String name = iter.next().toString();

                List<MultipartFile> files = new LinkedList<MultipartFile>();
                files = multiRequest.getFiles(name);

                // 一次遍历所有文件

                for (MultipartFile file : files) {
                    if (file != null) {
                        //一个文件
                        long fileSiz = file.getSize();
                        if (fileSiz > 0) {
                            String fileName = file.getOriginalFilename();// 原文件 名称
                            System.out.println(fileName);
                        }
                    }
                }

            }


        }
        return "/adminIndex";
    }
}
