package top.ssy.share.app.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.ssy.share.app.common.result.PageResult;
import top.ssy.share.app.mapper.NoticeMapper;
import top.ssy.share.app.model.entity.Notice;
import top.ssy.share.app.model.query.NoticeQuery;
import top.ssy.share.app.model.vo.NoticeVO;
import top.ssy.share.app.service.NoticeService;

import java.util.List;

/**
 * @author Lenovo
 */
@Slf4j
@Service
@AllArgsConstructor
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Override
    public List<NoticeVO> indexPageNotice() {
        return baseMapper.indexPageNotice();
    }

    @Override
    public PageResult<NoticeVO> getNoticeList(NoticeQuery query) {
        Page<NoticeVO> page=new Page<>(query.getPage(),query.getLimit());
        List<NoticeVO> list=baseMapper.getNoticePage(page,query);
        return new PageResult<>(list,page.getTotal());
    }

    @Override
    public NoticeVO detail(Integer id) {
        return baseMapper.getNoticeDetail(id);
    }

    @Override
    public List<NoticeVO> swiperNotice() {
        return baseMapper.swiperNotice();
    }
}
