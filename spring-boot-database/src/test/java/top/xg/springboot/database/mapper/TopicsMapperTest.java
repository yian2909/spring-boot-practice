package top.xg.springboot.database.mapper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xg.springboot.database.entity.Tags;
import top.xg.springboot.database.entity.Topics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class TopicsMapperTest {
    @Resource
    private TopicsMapper topicsMapper;
    @Test
    void findAll() {
        List<Topics> all = topicsMapper.findAll();
        List<Tags> tags = all.get(0).getTags();
        tags.forEach(tag -> log.info("{},{}",tag.getSectionId(),tag.getSectionTitle()));
    }
}