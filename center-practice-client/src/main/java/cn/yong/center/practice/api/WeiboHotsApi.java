package cn.yong.center.practice.api;

import cn.yong.center.practice.constants.enums.StatisticsEnum;
import cn.yong.center.practice.model.dto.WeiboHotStatisticsDTO;
import cn.yong.center.practice.model.dto.WeiboHotsDTO;
import cn.yong.center.practice.model.query.WeiboHotsQuery;
import cn.yong.common.result.JsonResult;
import com.deepexi.util.pageHelper.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ogy
 */
@Api(value = "微博热搜榜管理", tags = "微博热搜榜管理")
@RequestMapping("/center/practice/weibo-hots")
public interface WeiboHotsApi {

    /**
     * 批量保存微博热搜
     *
     * @param weiboHotsDTOS 数据
     * @return 配送单信息
     */
    @PostMapping("/batch")
    @ApiOperation(value = "批量保存微博热搜")
    JsonResult<Boolean> saveBatch(@RequestBody List<WeiboHotsDTO> weiboHotsDTOS);

    /**
    * 分页查询
     * @param weiboHotsQuery 查询条件
    *@return 分页信息
    */
    @GetMapping("/page")
    @ApiOperation(value = "分页查询微博热搜")
    JsonResult<PageBean<WeiboHotsDTO>> pageList(WeiboHotsQuery weiboHotsQuery);

    /** 统计热搜名的信息
     * @param hotName 热搜名
     * @param statisticsEnum 统计类型
    *@return  统计信息
    */
    @GetMapping("/statistics")
    @ApiOperation(value = "查询微博热搜统计")
    JsonResult<WeiboHotStatisticsDTO> getStatistics(@RequestParam("hotName") String hotName, @RequestParam("statisticsEnum") StatisticsEnum statisticsEnum);

}
