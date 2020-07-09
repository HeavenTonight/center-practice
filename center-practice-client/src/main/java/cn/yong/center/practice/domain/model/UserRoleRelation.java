package cn.yong.center.practice.domain.model;

import cn.yong.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ogy
 * @date 2020/6/30 11:16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_role_relation")
public class UserRoleRelation extends SuperEntity {
    private Long roleId;

    private Long userId;
}
