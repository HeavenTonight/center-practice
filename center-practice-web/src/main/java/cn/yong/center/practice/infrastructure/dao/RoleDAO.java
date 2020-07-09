package cn.yong.center.practice.infrastructure.dao;


import cn.yong.center.practice.domain.model.Role;
import cn.yong.center.practice.model.dto.RoleDTO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * 角色 DAO
 *
 * @author ogy
 */
public interface RoleDAO extends IService<Role> {
    /**根据userID获取角色list
     * @param userId 用户id
    *@return  角色
    */
    List<RoleDTO> getListByUserId(Long userId);
}
