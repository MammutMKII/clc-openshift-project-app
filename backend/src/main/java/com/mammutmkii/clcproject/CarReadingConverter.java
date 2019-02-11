package com.mammutmkii.clcproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@ReadingConverter
public class CarReadingConverter implements Converter<byte[], Car> {
    private final Jackson2JsonRedisSerializer<Car> serializer;

    public CarReadingConverter() {
        serializer = new Jackson2JsonRedisSerializer<Car>(Car.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public Car convert(byte[] value) {
        return serializer.deserialize(value);
    }
}