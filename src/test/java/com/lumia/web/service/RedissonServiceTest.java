package com.lumia.web.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedissonServiceTest {


//    @Resource
//    private RedissonClient redissonClient;
//
//    @Test
//    public void testLock() {
//
//        RLock lock = redissonClient.getLock("lock");
//        lock.lock();
//
//        lock.unlock();
//
//    }
}
