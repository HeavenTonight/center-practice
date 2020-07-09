package cn.yong.center.practice.domain.service;


import cn.yong.center.practice.model.command.UserCommand;

/**
 * @author ogy
 * @date 2020/6/11 14:11
 */
public interface UserService {

    /**
     * 添加用户
     * @param userCommand 参数
     *@return  是否
     */
    Boolean addUser(UserCommand userCommand);
}
