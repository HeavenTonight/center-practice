package cn.yong.center.practice.model.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ogy
 * @date 2020/6/30 14:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户信息操作对象")
public class UserCommand {
    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户编码")
    private String userNo;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("头像")
    private String headPhoto;

    @ApiModelProperty("角色id")
    private Long roleId;
}
