package me.konghao.JPA1.springhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@ComponentScan(basePackages = { "me.konghao.JPA1.springhibernate.controller", "me.konghao.JPA1.springhibernate.entity",
		"me.konghao.JPA1.springhibernate.Service", "me.konghao.JPA1.springhibernate.InterFace" })*/
@SpringBootApplication()
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
