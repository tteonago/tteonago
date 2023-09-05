package com.tteonago;

import com.fasterxml.jackson.databind.type.TypeFactory;
import com.tteonago.hotel.dto.AreaDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, List<AreaDTO>> areaRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, List<AreaDTO>> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(List.class));
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(TypeFactory.defaultInstance().constructParametricType(List.class, AreaDTO.class)));

        return redisTemplate;
    }
}
