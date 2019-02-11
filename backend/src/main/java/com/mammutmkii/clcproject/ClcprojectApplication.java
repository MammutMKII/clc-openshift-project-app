package com.mammutmkii.clcproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootApplication
public class ClcprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClcprojectApplication.class, args);
	}

	@Autowired
	private RedisTemplate<String, Car> template;

	@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
					"AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				template.opsForList().leftPush(car.getName(), car);
			});
			Set keys = template.keys("*");
			List<Car> bugattis = template.opsForList().range("Bugatti", 0, -1);
			System.out.println(keys);
			System.out.println(bugattis);
		};
	}
}

