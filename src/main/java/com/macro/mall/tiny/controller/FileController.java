package com.macro.mall.tiny.controller;

import cn.hutool.core.date.DateTime;
import com.google.api.client.util.Value;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.common.utils.FtpUtils;
import com.macro.mall.tiny.dto.MinioUploadDto;
import com.macro.mall.tiny.mbg.model.SysDictType;
import com.macro.mall.tiny.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.IOException;

@Api(tags = "FileController", description = "文件上传")
@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FtpUtils ftpUtils;
    @Autowired
    private UploadFileService uploadFileService;

    @ApiOperation("上传文件")
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> uploadFile (MultipartFile multipartFile) throws IOException {
        String oldFileName = multipartFile.getOriginalFilename();
        String newFileName = "ssss";

        //截取老文件名的后缀
        String substring = oldFileName.substring(oldFileName.lastIndexOf("."));
        //将后缀放在新文件名的后面
        newFileName = newFileName + substring;
        //生成路径
        String filePath = new DateTime().toString("yyyy/MM/dd");
        Boolean resultBoolean = ftpUtils.uploadFile(filePath,newFileName,multipartFile.getInputStream());
       if(resultBoolean)
       {
           return  CommonResult.success(filePath+newFileName);

       }
       else{
           return  CommonResult.failed("上传失败");
       }

    }

    @ApiOperation("上传图片")
    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult uploadImage (MultipartFile multipartFile) {
        try {
            MinioUploadDto minioUploadDto=uploadFileService.uploadFileByMinio(multipartFile);
            return  CommonResult.success(minioUploadDto);
        } catch (Exception e) {
            e.printStackTrace();
            return  CommonResult.failed(e.toString());
        }


    }

    @ApiOperation("删除minio 服务器 上的文件")
    @RequestMapping(value = "deleteMinioFile", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteMinioFile (@RequestParam("objectName") String fileUrl) {

            Boolean result =uploadFileService.deleteFileByMinio(fileUrl);
            if(result)
            {
                return  CommonResult.success("删除成功");

            }
           return  CommonResult.failed("删除失败");


    }



}
