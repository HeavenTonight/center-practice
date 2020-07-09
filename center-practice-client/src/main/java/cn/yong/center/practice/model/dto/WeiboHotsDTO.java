package cn.yong.center.practice.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

/**
 * @author ogy
 * @date 2020/6/11 13:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("热搜信息对象")
public class WeiboHotsDTO {
    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("热搜排名")
    private Integer hotTop;

    @ApiModelProperty("热搜名")
    private  String hotName;

    @ApiModelProperty("热度")
    private Long hotHeat;

    @ApiModelProperty("热搜标识")
    private  String hotMark;

    @ApiModelProperty("热搜更新时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date hotUpdateTime;

    @ApiModelProperty("热搜标识")
    private  String hotHref;

    @ApiModelProperty("创建时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty("备注")
    private String remark;
}
