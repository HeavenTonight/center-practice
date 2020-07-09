package cn.yong.center.practice.constants.constant;

/**认证相关常量
 * @author ogy
 * @date 2020/6/30 10:01
 */
public class AuthorizationConstants {
    public static final String LOGIN_PRIFIX_END = "practice:backend:user:";
    public static final String AUTHORIZATION = "Authorization";
    public static final String ISSUER_CENTER_PRACTICE="practice";
    public static final String USER_NO="userNo";
    public static final Long EXPIRATIONDATE = 7200L;
    private AuthorizationConstants() {
    }
}
