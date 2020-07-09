package cn.yong.center.practice.infrastructure.mapper;

import cn.yong.center.practice.domain.model.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author ogy
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据角色id获取菜单
     * @param roleIds 角色id
     *@return  菜单
     */
    List<Menu> getListByRoleIds(@Param("roleIds") Set<Long> roleIds);
}