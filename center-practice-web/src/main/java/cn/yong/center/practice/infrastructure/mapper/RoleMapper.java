package cn.yong.center.practice.infrastructure.mapper;

import cn.yong.center.practice.domain.model.Role;
import cn.yong.center.practice.model.dto.RoleDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ogy
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**根据userID获取角色list
     * @param userId 用户id
     *@return  角色
     */
    List<RoleDTO> getListByUserId(@Param("userId") Long userId);

}