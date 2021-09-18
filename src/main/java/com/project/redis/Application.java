package com.project.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import redis.clients.jedis.Jedis;

@SpringBootApplication
@EnableCaching
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		Jedis jedis = new Jedis();

		//Set name cache
		jedis.set("name", "steve");

		String name = jedis.get("name");

		//Set nameList cache
		String nameList = "nameList";

		jedis.lpush(nameList, "john", "mery", "miley");

		String lastName = jedis.lpop(nameList);

		String secondLastName = jedis.lpop(nameList);

		jedis.close();
	}
}
