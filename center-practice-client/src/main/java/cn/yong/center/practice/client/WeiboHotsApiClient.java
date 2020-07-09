package cn.yong.center.practice.client;

import cn.yong.center.practice.api.WeiboHotsApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 微博热搜管理 feignClient
 *
 * @author ogy
 */
@FeignClient(name = "center-practice")
public interface WeiboHotsApiClient extends WeiboHotsApi {
}
