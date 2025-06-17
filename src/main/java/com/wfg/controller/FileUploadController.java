package com.wfg.controller;


import com.wfg.service.FileUploadService;
import com.wfg.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/student")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

//    // MultipartFile： 接受上传的文件表单数据
    @PostMapping("/fileUpload")
    public Result<String> fileUploadService(@RequestParam(value="file")MultipartFile multipartFile){
        String fileUrl = fileUploadService.fileUpload(multipartFile) ;
  
        return  Result.success(fileUrl);
    }

}

//@RestController
//@RequestMapping("/admin/system")
//public class FileUploadController {
//
//    @Autowired
//    private FileUploadService fileUploadService ;
//
//    @PostMapping(value = "/fileUpload")
//    public Result<String> fileUploadService(@RequestParam(value = "file") MultipartFile multipartFile) {
//        String fileUrl = fileUploadService.fileUpload(multipartFile) ;
//        return Result.build(fileUrl , ResultCodeEnum.SUCCESS) ;
//    }
//
//}