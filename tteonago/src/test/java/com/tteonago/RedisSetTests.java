package com.tteonago;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataRedisTest
class RedisSetTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void testRedisConnection() {
        redisTemplate.opsForValue().set("key", "value");
        String result = redisTemplate.opsForValue().get("key");
        assertThat(result).isEqualTo("value");
    }
}
