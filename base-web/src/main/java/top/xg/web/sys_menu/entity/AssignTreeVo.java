package top.xg.web.sys_menu.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 */
@Data
public class AssignTreeVo {
    private List<SysMenu> menuList = new ArrayList<>();
    private Object[] checkList;
}
