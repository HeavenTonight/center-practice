package cn.yong.center.practice.infrastructure.dao.impl;

import cn.yong.center.practice.domain.model.Menu;
import cn.yong.center.practice.infrastructure.dao.MenuDAO;
import cn.yong.center.practice.infrastructure.mapper.MenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;


/**
 * 配送单信息DAO组件实现
 *
 * @author ogy
 */
@Repository
public class MenuDAOImpl extends ServiceImpl<MenuMapper, Menu> implements MenuDAO {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getListByRoleIds(Set<Long> roleIds) {
        return menuMapper.getListByRoleIds(roleIds);
    }
}