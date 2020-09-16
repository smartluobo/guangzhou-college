package com.guangzhou.college;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.guangzhou.college.dao")
public class GuangzhouCollegeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuangzhouCollegeApplication.class, args);
	}

}
