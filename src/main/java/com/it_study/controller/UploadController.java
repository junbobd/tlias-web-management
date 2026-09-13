package com.it_study.controller;

import com.it_study.pojo.Result;
import com.it_study.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@RestController
public class UploadController {
    //本地存储方式
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws Exception{
//        log.info("文件上传,{},{},{}",username,age,image);
//
//        //将接收到的文件存储在磁盘的目录当中
//        String originalFilename = image.getOriginalFilename();
//
//        //构造唯一的文件名 - uuid
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);//获取拓展名
//        String newFileName= UUID.randomUUID().toString()+extname;
//        log.info("新的文件名：{}",newFileName);
//
//        //将文件保存在本地目录
//        image.transferTo(new File("D:\\Pictures\\tlias\\"+newFileName));
//
//        return Result.success();
//    }
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result uoload(MultipartFile image) throws IOException {
        log.info("文件上传，文件名:{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问的url为：{}",url);
        return Result.success(url);
    }


}
