package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.tedu.feign.HelloFeign;

@RestController
public class HelloControllerHystrix {
	
	@Autowired
	private HelloFeign helloFeign;
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="helloHystrix")
	public String hello(@PathVariable("name") String name){
		
	return helloFeign.hello(name);	
	}
	public String helloHystrix(String name){
		
		return "duanlu";
		//return name;
	}
	
	
}
