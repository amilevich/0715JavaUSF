package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
/*
 * By default, the configuration values are read on the client's 
 * startup and never again.
 * You can force a bean to refresh its configuration (that is to 
 * pull updated values from the Config Server) by annotating
 * the controller with @RefreshScope.
 * (trigger a refresh event)
 */
public class ConfigController {

	@Value("${message: Look at this message, it is cool and stuff}")
	private String testString;
	
	@GetMapping("/test")
	public String testMethod() {
		return testString;
	}
}
