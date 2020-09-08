//package com.example.demo;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.client.RestTemplate;
//
//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.DiscoveryClient;
//
//@Controller
//public class WebClientController {
//  @Autowired
//  private DiscoveryClient discoveryClient;
//
//  @GetMapping("/")
//  public String handleRequest(Model model) {
//      //accessing hello-service
//      List<InstanceInfo> instances = discoveryClient.getInstancesById("eureka-client-service");
//      if (instances != null && instances.size() > 0) {
//          InstanceInfo serviceInstance = instances.get(0);
//          String url = serviceInstance.getId().toString();
//          url = url + "/hello";
//          RestTemplate restTemplate = new RestTemplate();
//          HelloObject helloObject = restTemplate.getForObject(url,
//                  HelloObject.class);
//          model.addAttribute("msg", helloObject.getMessage());
//          model.addAttribute("time", LocalDateTime.now());
//      }
//      return "hello-page";
//  }
//}