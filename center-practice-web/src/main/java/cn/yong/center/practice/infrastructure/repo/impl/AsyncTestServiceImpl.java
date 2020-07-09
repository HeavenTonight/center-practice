package cn.yong.center.practice.infrastructure.repo.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/** 异步服务
 * @author ogy
 * @date 2020/6/19 17:18
 */
@Service
@Slf4j
public class AsyncTestServiceImpl {
    @Async("asyncTaskExecutor")
    public void testAsync(){
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        integers.forEach(integer -> {
            log.info("值为：{}",integer);
        });

    }
}
