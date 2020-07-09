package cn.yong.center.practice.domain.model;

import cn.yong.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ogy
 * @date 2020/6/30 11:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User extends SuperEntity {
    private String userNo;

    private String userName;

    private String password;

    private String headPhoto;
}
