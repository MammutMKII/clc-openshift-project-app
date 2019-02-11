package com.mammutmkii.clcproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.MappingRedisConverter;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.core.convert.ReferenceResolver;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Arrays;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {
    @Bean
    public RedisTemplate<String, Car> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Car> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Car.class));
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new Jackson2JsonRedisSerializer<>(Car.class));
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Car.class));
        template.setEnableDefaultSerializer(true);
        return template;
    }

    @Bean
    public MappingRedisConverter redisConverter(RedisMappingContext mappingContext,
                                                RedisCustomConversions customConversions,
                                                ReferenceResolver referenceResolver) {

        MappingRedisConverter mappingRedisConverter = new MappingRedisConverter(mappingContext, null, referenceResolver);

        mappingRedisConverter.setCustomConversions(customConversions);

        return mappingRedisConverter;
    }

    @Bean
    public RedisCustomConversions redisCustomConversions() {
        return new RedisCustomConversions(Arrays.asList(new CarReadingConverter(), new CarWritingConverter()));
    }
}
