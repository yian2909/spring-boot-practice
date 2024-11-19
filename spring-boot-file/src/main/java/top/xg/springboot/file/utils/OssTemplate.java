package top.xg.springboot.file.utils;

import com.aliyun.oss.OSS;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.xg.springboot.file.config.OssConfig;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author Lenovo
 */
@Component
public class OssTemplate {
    @Resource
    private OssConfig ossConfig;
    @Resource
    private OSS ossClient;

    public String uploadFile(MultipartFile file) {
        try{
            String originalFilename = file.getOriginalFilename();
            if (originalFilename == null) {
                throw new IllegalArgumentException("文件名不能为空");
            }
            String fileName = UUID.randomUUID().toString() + "_" + originalFilename;
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(ossConfig.getBucket(), fileName, inputStream);
            return "https://" + ossConfig.getBucket() + "." + ossConfig.getEndpoint().replace("https://","") + "/" + fileName;
        }catch (Exception e){
            throw new RuntimeException("文件上传失败",e);
        }
    }
}
