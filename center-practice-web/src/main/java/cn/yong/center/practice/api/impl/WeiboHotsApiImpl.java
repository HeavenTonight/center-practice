package cn.yong.center.practice.api.impl;

import cn.yong.center.practice.api.WeiboHotsApi;
import cn.yong.center.practice.constants.enums.StatisticsEnum;
import cn.yong.center.practice.domain.service.WeiboHotsService;
import cn.yong.center.practice.model.dto.WeiboHotStatisticsDTO;
import cn.yong.center.practice.model.dto.WeiboHotsDTO;
import cn.yong.center.practice.model.query.WeiboHotsQuery;
import cn.yong.common.exception.BizException;
import cn.yong.common.result.JsonResult;
import com.deepexi.util.StringUtil;
import com.deepexi.util.pageHelper.PageBean;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ogy
 */
@RestController
public class WeiboHotsApiImpl implements WeiboHotsApi {

    @Resource
    private WeiboHotsService weiboHotsService;


    @Override
    public JsonResult<Boolean> saveBatch(List<WeiboHotsDTO> weiboHotsDTOS) {
        return JsonResult.create(weiboHotsService.saveBatch(null));
    }

    @Override
    public JsonResult<PageBean<WeiboHotsDTO>> pageList(WeiboHotsQuery weiboHotsQuery) {
        return JsonResult.create(weiboHotsService.pageList(weiboHotsQuery));
    }

    @Override
    public JsonResult<WeiboHotStatisticsDTO> getStatistics(String hotName, StatisticsEnum statisticsEnum) {
        if(StringUtil.isBlank(hotName)){
            throw new BizException("参数错误！");
        }
        return JsonResult.create(weiboHotsService.getStatistics(hotName,statisticsEnum));
    }
}
