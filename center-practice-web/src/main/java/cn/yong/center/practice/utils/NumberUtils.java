package cn.yong.center.practice.utils;


import org.springframework.data.redis.core.RedisTemplate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author ogy
 * @date 2020/5/25 9:56
 */
public class NumberUtils {
    public static final String USER_NO_KEY = "center:practice:userNo:";
    private NumberUtils(){
    }


    /**
    * 生成用户编号
     * @param redisTemplate redis
    *@return 用户编号
    */
    public static String generateUserNo(RedisTemplate redisTemplate) {
        String time = DateUtils.getYMDString(new Date());
        String key = USER_NO_KEY+time;
        Boolean aBoolean = redisTemplate.hasKey(key);
        if (!aBoolean){
            //设置过期时间
            redisTemplate.opsForValue().set(key,0,DateUtils.getRemainSecondsOneDay(new Date()), TimeUnit.SECONDS);
        }
        Long increment = redisTemplate.opsForValue().increment(key);
        //默认编码需要7位，位数不够前面补0
        String formatNum = String.format("%04d", increment);
        return time+formatNum;
    }


}
