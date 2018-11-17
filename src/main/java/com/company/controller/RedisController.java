package com.company.controller;

import com.company.common.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guofa.liu@kingtroldata.com
 * @description
 * @create 2018/11/17 13:00
 */

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String TEST_KEY = "test";
    private static final String TEST_KEY_HASH = "htest";

    @RequestMapping("/set")
    public void set(String value){
        stringRedisTemplate.opsForValue().set(TEST_KEY, value);
    }

    @RequestMapping("/get")
    public String get(){
        return stringRedisTemplate.opsForValue().get(TEST_KEY);
    }


    @RequestMapping("/hset")
    public void hset(String field, String value){
        stringRedisTemplate.opsForHash().put(TEST_KEY_HASH, field, value);
    }

    @RequestMapping("/hget")
    public Object hget(String field){
        return stringRedisTemplate.opsForHash().get(TEST_KEY_HASH, field);
    }
}
