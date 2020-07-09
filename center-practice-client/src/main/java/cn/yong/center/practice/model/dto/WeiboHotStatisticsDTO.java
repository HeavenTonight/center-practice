package cn.yong.center.practice.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ogy
 * @date 2020/6/24 16:19
 */
@Data
@ApiModel("微博热搜统计对象")
public class WeiboHotStatisticsDTO {
    @ApiModelProperty("key值集合")
    private List<String> keyData;
    @ApiModelProperty("value值集合")
    private List<Long> valueData;
}
