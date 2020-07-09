package cn.yong.center.practice.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ogy
 * @date 2020/7/1 10:15
 */
@Data
@ApiModel("菜单查看对象")
public class MenuDTO {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "菜单名字")
    private String menuName;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "路劲")
    private String path;

    @ApiModelProperty(value = "父菜单id")
    private Long parentId;

    @ApiModelProperty(value = "类型，0：菜单，1：页面，2：操作")
    private Integer type;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "排序")
    private Long sort;

    @ApiModelProperty(value = "子菜单列表")
    private List<MenuDTO> menuDTOS;
}
