package cn.yong.center.practice.infrastructure.mapper;

import cn.yong.center.practice.domain.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author ogy
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}