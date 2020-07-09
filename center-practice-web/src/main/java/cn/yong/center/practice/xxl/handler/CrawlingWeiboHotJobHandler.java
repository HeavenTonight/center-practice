package cn.yong.center.practice.xxl.handler;

import cn.yong.center.practice.domain.service.WeiboHotsService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/** 爬取微博热榜的job处理器
 * @author ogy
 * @date 2020/6/11 15:45
 */
@Component
@Slf4j
public class CrawlingWeiboHotJobHandler {
    @Resource
    private WeiboHotsService weiboHotsService;

    @XxlJob("crawlingWeiboHotJobHandler")
    public ReturnT<String> crawlingWeiboHotJobHandler(String param){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        weiboHotsService.saveBatch(null);
        stopWatch.stop();
        XxlJobLogger.log("爬取微博热搜用时:{}秒",stopWatch.getTotalTimeSeconds());
        return ReturnT.SUCCESS;
    }
}
