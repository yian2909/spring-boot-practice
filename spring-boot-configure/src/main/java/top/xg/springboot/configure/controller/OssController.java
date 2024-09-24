package top.xg.springboot.configure.controller;

import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.xg.springboot.configure.util.OssUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/oss")
public class OssController {
    @Resource
    private OssUtil ossUtil;

    @PostMapping("/upload")
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = ossUtil.uploadFile(file);
        Map<String, Object> map = new HashMap<>();
        map.put("fileUrl", fileUrl);
        return map;
    }
}
