package org.mrpaulwoods.employee

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
class EmployeeApplication extends WebMvcConfigurerAdapter {

	static void main(String[] args) {
		SpringApplication.run EmployeeApplication, args
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login")
		registry.addViewController("/logout").setViewName("logout")
	}

}
