package cn.yong.center.practice.domain.service;


import cn.yong.center.practice.model.dto.UserDTO;

/**
 * @author ogy
 * @date 2020/6/11 14:11
 */
public interface AuthService {
    /**后台管理系统登录
     * @param userNo 用户账号
     * @param password 密码
     *@return  信息
     */
    UserDTO backendLogin(String userNo, String password);
}
