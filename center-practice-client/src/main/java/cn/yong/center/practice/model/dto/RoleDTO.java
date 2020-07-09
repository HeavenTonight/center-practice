package cn.yong.center.practice.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ogy
 * @date 2020/7/1 10:15
 */
@Data
@ApiModel("角色查看对象")
public class RoleDTO {
    private Long id;

    private String roleName;

    private Integer status;
}
