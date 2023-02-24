package com.gousade.paint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gousade")
@MapperScan("com.**.mapper")
@SpringBootApplication
public class AiPaintServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiPaintServerApplication.class, args);
	}

}
