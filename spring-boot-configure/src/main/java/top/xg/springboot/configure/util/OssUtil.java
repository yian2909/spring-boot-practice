package top.xg.springboot.configure.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.xg.springboot.configure.config.OssConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class OssUtil {
    @Resource
    private OssConfig ossConfig;
    @Resource
    private OSS ossClient;

    public String uploadFile(MultipartFile file) {
        try{
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null || originalFilename.equals("")) {
                throw new IllegalArgumentException("文件名不拿为空");
            }
            String fileName = UUID.randomUUID().toString() + "_" + originalFilename;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ossConfig.getBucketName(), fileName, inputStream);
            return "https://" + ossConfig.getBucketName() + "." + ossConfig.getEndpoint().replace("https://","") + "/" + fileName;
        }catch (Exception e){
            throw new RuntimeException("文件上传失败",e);
        }
    }
//    public String ossUpload(MultipartFile file) {
//        String endpoint = ossConfig.getEndpoint();
//        String bucket = ossConfig.getBucket();
//        String dir = ossConfig.getDir();
//        String host = ossConfig.getHost();
//        String ak = ossConfig.getAk();
//        String secret = ossConfig.getSecret();
//        OSS ossClient = new OSSClientBuilder().build(endpoint,ak,secret);
//        String uploadPath = dir + file.getOriginalFilename();
//        InputStream inputStream = null;
//        try {
//            inputStream = file.getInputStream();
//        }catch (IOException e){
//            throw new RuntimeException(e);
//        }
//        ossClient.putObject(bucket,uploadPath,inputStream);
//        ossClient.shutdown();
//        return host + "/" + uploadPath;
//    }
}
