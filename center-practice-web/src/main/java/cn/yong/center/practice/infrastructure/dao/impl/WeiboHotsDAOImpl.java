package cn.yong.center.practice.infrastructure.dao.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.yong.center.practice.domain.model.WeiboHots;
import cn.yong.center.practice.infrastructure.dao.WeiboHotsDAO;
import cn.yong.center.practice.infrastructure.mapper.WeiboHotsMapper;
import cn.yong.center.practice.model.dto.WeiboHotCountDTO;
import cn.yong.center.practice.model.dto.WeiboHotsDTO;
import cn.yong.center.practice.model.query.WeiboHotsQuery;
import cn.yong.center.practice.utils.DateUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepexi.util.pageHelper.PageBean;
import com.github.pagehelper.page.PageMethod;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


/**
 * 配送单信息DAO组件实现
 *
 * @author ogy
 */
@Repository
public class WeiboHotsDAOImpl extends ServiceImpl<WeiboHotsMapper, WeiboHots> implements WeiboHotsDAO {
    @Resource
    private WeiboHotsMapper weiboHotsMapper;


    @Override
    public PageBean<WeiboHotsDTO> pageList(WeiboHotsQuery weiboHotsQuery) {
        LocalDateTime startTime=null;
        LocalDateTime endTime=null;
        PageMethod.startPage(weiboHotsQuery.getPage(),weiboHotsQuery.getSize());
        //判断查询时间
        if (!BeanUtil.isEmpty(weiboHotsQuery.getStartTime())&&!BeanUtil.isEmpty(weiboHotsQuery.getEndTime())) {
            //都是有时间的
            startTime=DateUtils.long2LocalDateTime(weiboHotsQuery.getStartTime());
            endTime=DateUtils.long2LocalDateTime(weiboHotsQuery.getEndTime());
        }
        if (BeanUtil.isEmpty(weiboHotsQuery.getStartTime())&&!BeanUtil.isEmpty(weiboHotsQuery.getEndTime())) {
            //查询这天的最小时间到最大时间
            LocalDateTime localDateTime  = DateUtils.long2LocalDateTime(weiboHotsQuery.getEndTime());
            startTime = localDateTime.with(LocalTime.MIN);
            endTime = localDateTime.with(LocalTime.MAX);
        }
        List<WeiboHotsDTO> weiboHotsDTOS = weiboHotsMapper.pageList(weiboHotsQuery, startTime, endTime);
        return new PageBean<>(weiboHotsDTOS);
    }

    @Override
    public List<WeiboHotsDTO> notPageList(WeiboHotsQuery weiboHotsQuery) {
        return  weiboHotsMapper.pageList(weiboHotsQuery, null, null);
    }

    @Override
    public List<WeiboHotCountDTO> getWeiboHotTopCount(String hotName) {
        return weiboHotsMapper.getWeiboHotTopCount(hotName);
    }

    @Override
    public List<WeiboHotCountDTO> getWeiboHotMarkCount(String hotName) {
        return weiboHotsMapper.getWeiboHotMarkCount(hotName);
    }
}