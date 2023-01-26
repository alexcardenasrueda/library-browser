package com.unir.librarybrowser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
@EnableDiscoveryClient
public class LibraryBrowserApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

//	@Bean
//	public RestTemplate restTemplate() {
//		RestTemplate build = new RestTemplateBuilder().build();
//		return build;
//	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryBrowserApplication.class, args);
	}

}
