package cn.yong.center.practice.domain.model;

import cn.yong.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ogy
 * @date 2020/6/30 11:12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("menu")
public class Menu extends SuperEntity {
    private String menuName;

    private String icon;

    private String path;

    private Long parentId;

    private Integer type;

    private Integer status;

    private Long sort;
}
