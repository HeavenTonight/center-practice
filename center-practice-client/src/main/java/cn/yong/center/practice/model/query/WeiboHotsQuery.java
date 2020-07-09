package cn.yong.center.practice.model.query;

import cn.yong.common.model.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ogy
 * @date 2020/6/11 13:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("热搜信息查询对象")
public class WeiboHotsQuery extends PageQuery {

    @ApiModelProperty("热搜排名")
    private Integer hotTop;

    @ApiModelProperty("热搜名")
    private  String hotName;

    @ApiModelProperty("热搜标识")
    private  String hotMark;

    @ApiModelProperty("查询开始时间")
    private Long startTime;

    @ApiModelProperty("查询结束/日时间")
    private Long endTime;

}
