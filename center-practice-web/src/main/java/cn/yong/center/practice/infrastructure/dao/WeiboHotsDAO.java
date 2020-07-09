package cn.yong.center.practice.infrastructure.dao;


import cn.yong.center.practice.domain.model.WeiboHots;
import cn.yong.center.practice.model.dto.WeiboHotCountDTO;
import cn.yong.center.practice.model.dto.WeiboHotsDTO;
import cn.yong.center.practice.model.query.WeiboHotsQuery;
import com.baomidou.mybatisplus.extension.service.IService;
import com.deepexi.util.pageHelper.PageBean;
import org.hibernate.validator.constraints.Mod11Check;

import java.util.List;


/**
 * 配送单 DAO
 *
 * @author ogy
 */
public interface WeiboHotsDAO extends IService<WeiboHots> {

    /**
     * 分页查询
     * @param weiboHotsQuery 查询条件
     *@return 分页信息
     */
    PageBean<WeiboHotsDTO> pageList(WeiboHotsQuery weiboHotsQuery);

    /**
    * 不分页查询
     * @param weiboHotsQuery 条件
    *@return 集合信息
    */
    List<WeiboHotsDTO> notPageList(WeiboHotsQuery weiboHotsQuery);

    /**
    * 根据热搜名获取排名数量信息
     * @param hotName 热搜名
    *@return  数量信息
    */
    List<WeiboHotCountDTO> getWeiboHotTopCount(String hotName);

    /**
     * 根据热搜名获取标识数量信息
     * @param hotName 热搜名
     *@return  数量信息
     */
    List<WeiboHotCountDTO> getWeiboHotMarkCount(String hotName);

}
