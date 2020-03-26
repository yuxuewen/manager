package com.macro.mall.tiny.service;

import com.macro.mall.tiny.dto.MinioUploadDto;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

    MinioUploadDto uploadFileByMinio(MultipartFile file) throws InvalidPortException, InvalidEndpointException, Exception;
    Boolean deleteFileByMinio(String objectName);

}
