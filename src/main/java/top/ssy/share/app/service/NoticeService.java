package top.ssy.share.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.ssy.share.app.common.result.PageResult;
import top.ssy.share.app.model.entity.Notice;
import top.ssy.share.app.model.query.NoticeQuery;
import top.ssy.share.app.model.vo.NoticeVO;

import java.util.List;

/**
 * @author Lenovo
 */
public interface NoticeService extends IService<Notice> {
    List<NoticeVO> indexPageNotice();
    PageResult<NoticeVO> getNoticeList(NoticeQuery query);
    NoticeVO detail(Integer id);
    List<NoticeVO> swiperNotice();
}
