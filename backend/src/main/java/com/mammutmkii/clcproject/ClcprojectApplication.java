package com.mammutmkii.clcproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootApplication
public class ClcprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClcprojectApplication.class, args);
	}
}

