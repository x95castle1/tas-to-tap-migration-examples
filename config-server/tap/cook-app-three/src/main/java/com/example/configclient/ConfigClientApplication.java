package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${name:Name default}")
	private String name;
	@Value("${azure:Azure default}")
	private String azure;
	@Value("${logging:Logging default}")
	private String logging;
	@Value("${monitoring:Monitoring default}")
	private String monitoring;
	@Value("${rabbitmq:Rabbitmq default}")
	private String rabbit;
	@Value("${ocho:Ocho default}")
	private String ocho;


	@RequestMapping("/all")
	String getAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("name: " + this.name + "<br />");
		sb.append("ocho: " + this.ocho + "<br />");
		sb.append("azure: " + this.azure + "<br />");
		sb.append("logging: " + this.logging + "<br />");
		sb.append("monitoring: " + this.monitoring + "<br />");
		sb.append("rabbit: " + this.rabbit + "<br />");
		return sb.toString();
	}
}