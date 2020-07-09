package cn.yong.center.practice.infrastructure.dao;


import cn.yong.center.practice.domain.model.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;


/**
 * 菜单 DAO
 *
 * @author ogy
 */
public interface MenuDAO extends IService<Menu> {
    /**
    * 根据角色id获取菜单
     * @param roleIds 角色id
    *@return  菜单
    */
     List<Menu> getListByRoleIds(Set<Long> roleIds);

}
