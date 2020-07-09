package cn.yong.center.practice.domain.model;

import cn.yong.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author ogy
 * @date 2020/7/2 19:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_message")
public class UserMessage extends SuperEntity {

    private Long userId;

    private Integer status;

    private String message;

    private Date readTime;
}
