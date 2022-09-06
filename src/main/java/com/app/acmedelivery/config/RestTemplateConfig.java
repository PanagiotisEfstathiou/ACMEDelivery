package com.app.acmedelivery.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Configuration which manages how a RestTemplate bean is created. Contains simple configuration such as setting
 * connection timeout, etc.
 */
@Configuration
public class RestTemplateConfig {
	@Bean
	@Primary
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.setConnectTimeout(Duration.ofMillis(5000)).setReadTimeout(Duration.ofMillis(5000)).build();
	}

	@Bean
	@Scope("prototype")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
