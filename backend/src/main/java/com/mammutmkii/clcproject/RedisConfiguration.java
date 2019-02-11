package com.mammutmkii.clcproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, StockPrice> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, StockPrice> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(StockPrice.class));
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new Jackson2JsonRedisSerializer<>(StockPrice.class));
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(StockPrice.class));
        template.setEnableDefaultSerializer(true);
        return template;
    }
}
