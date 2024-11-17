package top.ssy.share.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.repository.query.Param;
import top.ssy.share.app.model.entity.Notice;
import top.ssy.share.app.model.query.NoticeQuery;
import top.ssy.share.app.model.vo.NoticeVO;

import java.util.List;

/**
 * @author Lenovo
 */
public interface NoticeMapper extends BaseMapper<Notice> {
    List<NoticeVO> indexPageNotice();
    List<NoticeVO> getNoticePage(Page<NoticeVO> page, @Param("query") NoticeQuery query);
    NoticeVO getNoticeDetail(Integer id);
    List<NoticeVO> swiperNotice();
}
