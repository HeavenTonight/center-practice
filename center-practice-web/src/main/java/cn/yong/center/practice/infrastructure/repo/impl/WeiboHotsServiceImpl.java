package cn.yong.center.practice.infrastructure.repo.impl;

import cn.hutool.core.collection.CollUtil;
import cn.yong.center.practice.constants.enums.StatisticsEnum;
import cn.yong.center.practice.domain.model.WeiboHots;
import cn.yong.center.practice.domain.service.WeiboHotsService;
import cn.yong.center.practice.infrastructure.dao.WeiboHotsDAO;
import cn.yong.center.practice.model.dto.WeiboHotCountDTO;
import cn.yong.center.practice.model.dto.WeiboHotStatisticsDTO;
import cn.yong.center.practice.model.dto.WeiboHotsDTO;
import cn.yong.center.practice.model.query.WeiboHotsQuery;
import cn.yong.center.practice.utils.DateUtils;
import cn.yong.common.util.CloneUtil;
import com.deepexi.util.StringUtil;
import com.deepexi.util.pageHelper.PageBean;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ogy
 * @date 2020/6/11 14:11
 */
@Service
@Slf4j
public class WeiboHotsServiceImpl implements WeiboHotsService {
    @Resource
    private WeiboHotsDAO weiboHotsDAO;

    @Value("${weibo.hot.base-href-url}")
    private String baseHrefUrl;

    @Value("${weibo.hot.url}")
    private String hotUrl;

    @Override
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public Boolean saveBatch(List<WeiboHotsDTO> weiboHotsDTOS) {
        try {
            List<WeiboHotsDTO> weiboHotsList = crawlingWeiboHot();
            if (CollUtil.isNotEmpty(weiboHotsList)){
                weiboHotsDAO.saveBatch(CloneUtil.cloneList(weiboHotsList, WeiboHots.class));
            }
        }catch (Exception e){
            log.error("error:",e);
        }
        return true;
    }

    @Override
    public PageBean<WeiboHotsDTO> pageList(WeiboHotsQuery weiboHotsQuery) {
        return weiboHotsDAO.pageList(weiboHotsQuery);
    }

    @Override
    public WeiboHotStatisticsDTO getStatistics(String hotName, StatisticsEnum statisticsEnum) {
        WeiboHotStatisticsDTO weiboHotStatisticsDTO = new WeiboHotStatisticsDTO();
        List<String> keyData = new ArrayList<>();
        List<Long> valueData = new ArrayList<>();
        if (StatisticsEnum.HOT_HEAT.equals(statisticsEnum)){
            //按热度统计
            List<WeiboHotsDTO> weiboHotsDTOS = weiboHotsDAO.notPageList(WeiboHotsQuery.builder().hotName(hotName).build());
            weiboHotsDTOS.forEach(weiboHotsDTO -> {
                keyData.add(DateUtils.getDateTimeAsString(weiboHotsDTO.getCreatedTime(),DateUtils.DATE_FORMAT_STR_H_M_S));
                valueData.add(weiboHotsDTO.getHotHeat());
            });
        }
        if (StatisticsEnum.HOT_TOP.equals(statisticsEnum)){
            //按排名统计
            List<WeiboHotCountDTO> weiboHotTopCount = weiboHotsDAO.getWeiboHotTopCount(hotName);
            weiboHotTopCount.forEach(weiboHotCountDTO -> {
                keyData.add(weiboHotCountDTO.getHotTop().toString());
                valueData.add(weiboHotCountDTO.getHotTopCount());
            });

        }
        if (StatisticsEnum.HOT_MARK.equals(statisticsEnum)){
            //按标识统计
            List<WeiboHotCountDTO> weiboHotTopCount = weiboHotsDAO.getWeiboHotMarkCount(hotName);
            weiboHotTopCount.forEach(weiboHotCountDTO -> {
                keyData.add(StringUtil.isBlank(weiboHotCountDTO.getHotMark())?"无":weiboHotCountDTO.getHotMark());
                valueData.add(weiboHotCountDTO.getHotMarkCount());
            });
        }
        weiboHotStatisticsDTO.setKeyData(keyData);
        weiboHotStatisticsDTO.setValueData(valueData);
        return weiboHotStatisticsDTO;
    }

    /**
    *爬取微博热搜榜数据
    *@return  热搜榜数据
    */
    private List<WeiboHotsDTO> crawlingWeiboHot() throws IOException{
        Document doc = Jsoup.connect(hotUrl).get();
        Element content = doc.getElementById("pl_top_realtimehot");
        Date date = new Date();
        List<WeiboHotsDTO> weiboHotsDTOS = new ArrayList<>();
        Elements links = content.getElementsByTag("tr");
        for (Element link : links) {
            Elements top = link.getElementsByClass("td-01 ranktop");
            Elements hotMark = link.getElementsByClass("td-03");
            Elements elementsByClass = link.getElementsByClass("td-02");
            for (Element element:elementsByClass){
                WeiboHotsDTO weiboHotsDTO = new WeiboHotsDTO();
                Elements a = element.getElementsByTag("a");
                Elements span = element.getElementsByTag("span");
                if (StringUtil.isBlank(span.text())){
                    weiboHotsDTO.setHotHeat(99999L);
                }else {
                    weiboHotsDTO.setHotHeat(Long.parseLong(span.text()));
                }
                String href = a.attr("href").replace("%23","");
                weiboHotsDTO.setHotHref(baseHrefUrl+href);
                weiboHotsDTO.setHotName(a.text());
                if (StringUtil.isBlank(top.text())){
                    weiboHotsDTO.setHotTop(0);
                }else {
                    weiboHotsDTO.setHotTop(Integer.parseInt(top.text()));
                }
                weiboHotsDTO.setHotMark(hotMark.text());
                weiboHotsDTO.setHotUpdateTime(date);
                weiboHotsDTOS.add(weiboHotsDTO);
            }
        }
        return weiboHotsDTOS;
    }

}
