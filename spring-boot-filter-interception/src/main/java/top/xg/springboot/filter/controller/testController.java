package top.xg.springboot.filter.controller;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.filter.util.OssTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Lenovo
 */
@RestController
public class testController {
    @Resource
    private OssTemplate ossTemplate;

    @GetMapping("test")
    public String test() {
        return "test";
    }

    @PostMapping("upload")
    public ResponseEntity<String> uploadImage(HttpServletRequest request) throws IOException {
        String tempFilePath = (String) request.getAttribute("tempFilePath");
        if (tempFilePath == null) {
            return ResponseEntity.badRequest().body("未找到处理后的文件");
        }
        File file = new File(tempFilePath);
        FileInputStream input = new FileInputStream(file);
        String fileName = file.getName();
        String contentType = FileUtil.extName(fileName);
        MockMultipartFile image = new MockMultipartFile("file", fileName, contentType, input);
        ossTemplate.uploadFile(image);
        return ResponseEntity.ok("文件上传成功");
    }

}
