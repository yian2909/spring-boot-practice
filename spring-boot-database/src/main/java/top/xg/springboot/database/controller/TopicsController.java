package top.xg.springboot.database.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xg.springboot.database.common.ResponseResult;
import top.xg.springboot.database.entity.Topics;
import top.xg.springboot.database.mapper.TopicsMapper;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/zhihu")
public class TopicsController {
    private final TopicsMapper topicsMapper;

    @GetMapping("/topics")
    public ResponseResult getTopics() {
        return ResponseResult.builder()
                .code(200)
                .msg("请求成功")
                .data(topicsMapper.findAll())
                .build();
    }
}
