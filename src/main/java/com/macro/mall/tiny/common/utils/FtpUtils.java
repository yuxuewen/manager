package com.macro.mall.tiny.common.utils;
import com.macro.mall.tiny.controller.UmsAdminController;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FtpUtils {
    @Value("${ftp.host}")
    private String host;
    @Value("${ftp.port}")
    private int port;
    @Value("${ftp.username}")
    private String username;
    @Value("${ftp.password}")
    private String password;
    @Value("${ftp.baseFilePath}")
    private String baseFilePath;
    @Value("${ftp.baseImagePath}")
    private String baseImagePath;
    private static final Logger LOGGER = LoggerFactory.getLogger(FtpUtils.class);


    public  Boolean uploadFile(String filePath, String fileName, InputStream inputStream) throws IOException {
        //1、创建临时路径
        String tempPath="";
        //2、创建FTPClient对象（对于连接ftp服务器，以及上传和上传都必须要用到一个对象）
        FTPClient ftp=new FTPClient();
        try{
            //3、定义返回的状态码
            int reply;
            //4、连接ftp(当前项目所部署的服务器和ftp服务器之间可以相互通讯，表示连接成功)

            ftp.connect(host,port);
            ftp.enterLocalActiveMode();
            //5、输入账号和密码进行登录
            ftp.login(username,password);
            //6、接受状态码(如果成功，返回230，如果失败返回503)
            reply=ftp.getReplyCode();
            //7、根据状态码检测ftp的连接，调用isPositiveCompletion(reply)-->如果连接成功返回true，否则返回false
            if(!FTPReply.isPositiveCompletion(reply)){
                //说明连接失败，需要断开连接
                ftp.disconnect();
                LOGGER.error("ftp 连接失败"+reply);
                return false;
            }
            LOGGER.info("ftp 连接成功");
            //8、changWorkingDirectory(linux上的文件夹)：检测所传入的目录是否存在，如果存在返回true，否则返回false
            //baseFilePath+filePath-->home/ftp/www/2019/09/02
            if(!ftp.changeWorkingDirectory(baseFilePath+filePath)){
                //9、截取filePath:2019/09/02-->String[]:2019,09,02
                String[] dirs=filePath.split("/");
                //10、把baseFilePath(/home/ftp/www)-->tempPath
                tempPath=baseFilePath;

                for (String dir:dirs){
                    LOGGER.info("ftp "+dir);
                    //11、循环数组(第一次循环-->2019)
                    if(null==dir||"".equals(dir))
                        continue;//跳出本地循环，进入下一次循环
                    //12、更换临时路径：/home/ftp/www/2019
                    tempPath += "/" + dir;
                    //13、再次检测路径是否存在(/home/ftp/www/2019)-->返回false，说明路径不存在
                    if(!ftp.changeWorkingDirectory(tempPath)){
                        //14、makeDirectory():创建目录  返回Boolean雷类型，成功返回true
                        LOGGER.error(tempPath+"SSSSSSSS");
                        if(!ftp.makeDirectory(tempPath)){
                            LOGGER.error(ftp.makeDirectory(tempPath)+"SSSSSSSS");
                            return false;
                        }else {
                            //15、严谨判断（重新检测路径是否真的存在(检测是否创建成功)）
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            //16.把文件转换为二进制字符流的形式进行上传
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            LOGGER.info("ftp"+FTP.BINARY_FILE_TYPE);
            //17、这才是真正上传方法storeFile(filename,input),返回Boolean雷类型，上传成功返回true
            if (!ftp.storeFile(fileName, inputStream)) {
                LOGGER.error("转换失败");
                return false;
            }
            // 18.关闭输入流
            inputStream.close();
            // 19.退出ftp
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("转换失败"+e.toString());
            throw new IOException(e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    // 20.断开ftp的连接
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return true;
    }
}

