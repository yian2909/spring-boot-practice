package top.xg.zhihu.api.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.xg.zhihu.api.entity.Special;
import top.xg.zhihu.api.mapper.SpecialMapper;
import top.xg.zhihu.api.service.SpecialService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class SpecialServiceImpl implements SpecialService {
    @Resource
    public SpecialMapper specialMapper;


    @Override
    public List<Special> getAll() {
        List<Special> specials = specialMapper.selectAll();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        specials.forEach(special -> {
            String format =dateFormat.format(new Date(Long.parseLong(special.getUpdated() + "000")));
            special.setUpdated(format);
        });
        return specials;
    }

    @Override
    public List<Special> getByPage(int limit, int offset) {
        return specialMapper.selectByPage(limit, offset);
    }
}
