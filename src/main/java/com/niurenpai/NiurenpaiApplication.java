package com.niurenpai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.niurenpai")
@MapperScan("com.niurenpai.mapper.dao")
public class NiurenpaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiurenpaiApplication.class, args);
	}
}
