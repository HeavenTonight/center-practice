package cn.yong.center.practice.domain.model;

import cn.yong.common.model.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author ogy
 * @date 2020/6/11 13:39
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("weibo_hots")
public class WeiboHots extends SuperEntity {
    /**
     *热搜排名
     */
    private Integer hotTop;
    /**
     * 热搜名
     */
    private  String hotName;
    /**
     * 热度
     */
    private Long hotHeat;

    /**
     * 热搜标识
     */
    private  String hotMark;

    /**
     * 热搜更新时间
     */
    private Date hotUpdateTime;

    /**
     * 热搜标识
     */
    private  String hotHref;
}
