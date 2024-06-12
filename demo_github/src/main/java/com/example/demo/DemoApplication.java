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
@ComponentScan(basePackages  ="db_jasypt") //@Bean 인식

public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("스프링부트 시작");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("스프링부트 종료");

		System.out.println("로컬 sub1 브랜치에서 import함");
		
		System.out.println("로컬 main 브랜치에서 clone 이후 수정함");

		System.out.println("로컬 sub1브랜에서 생성한 main 브랜치에서 push함");
	}

}
