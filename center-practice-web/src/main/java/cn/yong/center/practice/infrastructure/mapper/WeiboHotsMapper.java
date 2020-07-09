package cn.yong.center.practice.infrastructure.mapper;

import cn.yong.center.practice.domain.model.WeiboHots;
import cn.yong.center.practice.model.dto.WeiboHotCountDTO;
import cn.yong.center.practice.model.dto.WeiboHotsDTO;
import cn.yong.center.practice.model.query.WeiboHotsQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ogy
 */
@Mapper
public interface WeiboHotsMapper extends BaseMapper<WeiboHots> {

    /**
     * 分页查询
     * @param weiboHotsQuery 查询条件
     *@return 分页信息
     */
    List<WeiboHotsDTO> pageList(@Param("weiboHotsQuery") WeiboHotsQuery weiboHotsQuery, @Param("startTime")LocalDateTime startTime,@Param("endTime")LocalDateTime endTime);

    /**
     * 根据热搜名获取排名数量信息
     * @param hotName 热搜名
     *@return  数量信息
     */
    List<WeiboHotCountDTO> getWeiboHotTopCount(@Param("hotName")String hotName);

    /**
     * 根据热搜名获取标识数量信息
     * @param hotName 热搜名
     *@return  数量信息
     */
    List<WeiboHotCountDTO> getWeiboHotMarkCount(@Param("hotName")String hotName);
}