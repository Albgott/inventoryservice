package com.albgott.inventoryservice;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.TimeZone;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
@RefreshScope

public class InventoryserviceApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryserviceApplication.class, args);
	}

}
