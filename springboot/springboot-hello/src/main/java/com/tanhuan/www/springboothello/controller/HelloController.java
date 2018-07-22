package com.tanhuan.www.springboothello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tanhuan.www.springboothello.exception.BusinessException;

@RestController
public class HelloController {
 
	//@value  自定义配置的
	@Value("${tanhuang.msg}")
	private String msg;
	
	@RequestMapping("/hello")
	public @ResponseBody String index(){
//		int no = 1/0;全局自动捕获异常
//		throw new BusinessException("100","用户名密码错误");自定义异常
		return this.msg;
	}
}
