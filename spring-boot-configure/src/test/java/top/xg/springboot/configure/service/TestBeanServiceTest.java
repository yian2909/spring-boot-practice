package top.xg.springboot.configure.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class TestBeanServiceTest {
    @Resource
    private ConfigurableApplicationContext ioc;
    @Test
    void testLoader() {
        boolean f = ioc.containsBean("testBeanService");
        assertTrue(f);
        TestBeanService testBeanService = (TestBeanService) ioc.getBean("testBeanService", TestBeanService.class);
        log.info(String.valueOf(testBeanService));
        assertEquals("SpringBoot",testBeanService.getName());
    }
}