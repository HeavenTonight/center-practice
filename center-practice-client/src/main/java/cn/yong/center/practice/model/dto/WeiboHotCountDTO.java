package cn.yong.center.practice.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author ogy
 * @date 2020/6/25 14:06
 */
@Data
@ApiModel("微博热搜数量统计对象")
public class WeiboHotCountDTO {
    /**
     *热搜排名
     */
    private Integer hotTop;

    /**
     *热搜排名数量
     */
    private Long hotTopCount;

    /**
     * 热搜标识
     */
    private  String hotMark;

    /**
     *热搜标识数量
     */
    private Long hotMarkCount;
}
