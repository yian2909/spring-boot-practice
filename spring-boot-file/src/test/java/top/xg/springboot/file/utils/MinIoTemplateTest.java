package top.xg.springboot.file.utils;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;

@SpringBootTest
@Slf4j
class MinIoTemplateTest {
    @Resource
    private MinIoTemplate minIoTemplate;

    @Test
    void bucketExists() throws Exception {
        boolean flag = minIoTemplate.bucketExists("avatar");
        log.info(String.valueOf(flag));
    }

    @Test
    void makeBucket() throws Exception{
        minIoTemplate.makeBucket("test1031");
    }

    @Test
    void putObject() throws Exception{
        File file = new File("C:/Users/Lenovo/Desktop/export/cat.jpg");
        String url = minIoTemplate.putObject("mqxu","test/gxde.jpg",new FileInputStream(file));
        log.info(url);
    }

    @Test
    void removeObject() throws Exception{
        minIoTemplate.removeObject("mqxu","test/gxde.jpg");
    }
}