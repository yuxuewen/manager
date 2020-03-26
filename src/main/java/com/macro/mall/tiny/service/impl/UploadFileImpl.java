package com.macro.mall.tiny.service.impl;


import com.macro.mall.tiny.dto.MinioUploadDto;
import com.macro.mall.tiny.service.UploadFileService;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class UploadFileImpl implements UploadFileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileImpl.class);

    @Value("${minio.endpoint}")
    private String ENDPOINT;
    @Value("${minio.bucketImageName}")
    private String BUCKET_NAME;
    @Value("${minio.accessKey}")
    private String ACCESS_KEY;
    @Value("${minio.secretKey}")
    private String SECRET_KEY;


    @Override
    public MinioUploadDto uploadFileByMinio(MultipartFile file) throws Exception {
        //创建一个MinIO的Java客户端
        LOGGER.info(ENDPOINT);

        MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
        boolean isExist = minioClient.bucketExists(BUCKET_NAME);
        if (isExist) {
            LOGGER.info("存储桶已经存在！");
        } else {
            //创建存储桶并设置只读权限
            minioClient.makeBucket(BUCKET_NAME);
            minioClient.setBucketPolicy(BUCKET_NAME, "*.*", PolicyType.READ_ONLY);
        }
        String filename = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // 设置存储对象名称
        String objectName = sdf.format(new Date()) + "/" + filename;
        // 使用putObject上传一个文件到存储桶中
        minioClient.putObject(BUCKET_NAME, objectName, file.getInputStream(), file.getContentType());
        LOGGER.info("文件上传成功!");
        MinioUploadDto minioUploadDto = new MinioUploadDto();
        minioUploadDto.setName(filename);
        minioUploadDto.setUrl(ENDPOINT + "/" + BUCKET_NAME + "/" + objectName);

        return minioUploadDto;
    }

    @Override
    public Boolean deleteFileByMinio(String objectName) {
        try {
            MinioClient minioClient = new MinioClient(ENDPOINT, ACCESS_KEY, SECRET_KEY);
            minioClient.removeObject(BUCKET_NAME, objectName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
