package com.example.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MemberApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MemberApplication.class, args);
		EurekaClient client = ctx.getBean(EurekaClient.class);// 取得EurekaClient的bean
		String url = client.getNextServerFromEureka("message-service", false).getHomePageUrl();// 取得Message服務的URL位址
		
		System.out.println("send request start...");
        sendRequest(url);
        System.out.println("send request end...");
		
	}

	private static void sendRequest(String url) {
		// TODO Auto-generated method stub
		final RestTemplate restTemplate = new RestTemplateBuilder().build();
		
		int memberId = 1;
		url = new StringBuilder(url).append("/messages/").append(memberId).toString();
		
		final String response = restTemplate.getForObject(url,String.class);// 呼叫Message服務的REST API，http://localhost:2224/messages/{messageId}
		System.out.println(response);
	}

}
