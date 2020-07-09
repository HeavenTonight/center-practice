package cn.yong.center.practice.domain.service;

import cn.yong.center.practice.constants.enums.StatisticsEnum;
import cn.yong.center.practice.model.dto.WeiboHotStatisticsDTO;
import cn.yong.center.practice.model.dto.WeiboHotsDTO;
import cn.yong.center.practice.model.query.WeiboHotsQuery;
import com.deepexi.util.pageHelper.PageBean;

import java.util.List;

/**
 * @author ogy
 * @date 2020/6/11 14:11
 */
public interface WeiboHotsService {
    /**
    * 批量保存
     * @param weiboHotsDTOS 数据
    *@return 是否成功
    */
    Boolean saveBatch(List<WeiboHotsDTO> weiboHotsDTOS);

    /**
     * 分页查询
     * @param weiboHotsQuery 查询条件
     *@return 分页信息
     */
    PageBean<WeiboHotsDTO> pageList(WeiboHotsQuery weiboHotsQuery);

    /** 统计热搜名的信息
     * @param hotName 热搜名
     * @param statisticsEnum 统计类型
     *@return  统计信息
     */
    WeiboHotStatisticsDTO getStatistics(String hotName, StatisticsEnum statisticsEnum);
}
