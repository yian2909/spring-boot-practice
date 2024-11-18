package top.ssy.share.app.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Lenovo
 */
@Data
@AllArgsConstructor
public class UserActionListInfo {
    private long total;
    private List<Integer> resourceIdList;
}
