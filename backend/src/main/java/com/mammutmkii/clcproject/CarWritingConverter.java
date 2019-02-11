package com.mammutmkii.clcproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@WritingConverter
public class CarWritingConverter implements Converter<Car, byte[]> {
    private final Jackson2JsonRedisSerializer<Car> serializer;

    public CarWritingConverter() {
        serializer = new Jackson2JsonRedisSerializer<>(Car.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public byte[] convert(Car value) {
        return serializer.serialize(value);
    }
}