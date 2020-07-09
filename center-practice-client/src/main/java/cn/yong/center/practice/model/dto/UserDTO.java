package cn.yong.center.practice.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ogy
 * @date 2020/6/30 14:37
 */
@Data
@ApiModel("用户查看对象")
public class UserDTO {
    @ApiModelProperty("用户id")
    private Long id;

    @ApiModelProperty("用户编码")
    private String userNo;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("头像")
    private String headPhoto;

    @ApiModelProperty("JWT")
    private String jwt;

    @ApiModelProperty("角色")
    private List<RoleDTO> roles;

    @ApiModelProperty("菜单")
    private List<MenuDTO> menus;
}
