//package com.example.demo;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.DiscoveryClient;
//
//@RestController
//public class HelloController {
//  private AtomicLong counter = new AtomicLong();
//
//  @GetMapping("/hello")
//  public HelloObject getHelloWordObject() {
//      HelloObject hello = new HelloObject();
//      hello.setMessage("Hi there! you are number " + counter.incrementAndGet());
//      return hello;
//  }
//}