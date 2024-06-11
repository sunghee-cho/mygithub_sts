package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
//@ComponentScan(basePackages={"errors","spring.mybatis.board"})
//@ComponentScan(basePackages="upload")
//@ComponentScan(basePackages = "websocket")

@ComponentScan(basePackages = "boardmapper")
@MapperScan("boardmapper")

@ComponentScan(basePackages = "react.session")
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("스프링부트 시작");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("스프링부트 종료");

		System.out.println("깃헙 main브랜치에서 clone하여 수정함");

		System.out.println("깃헙 sub1 브랜치에서 import함");
	}

}
