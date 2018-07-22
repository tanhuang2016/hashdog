package com.tanhuan.www.springboothello.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**全局补货异常,只要作用在@RquestMapping方法上的所有异常信息都会被捕获到
 * @ControllerAdvice异常统一处理的注解
 * @author th-pc
 *
 */
@ControllerAdvice
public class MyControllerAdvice {

	/**
	 * @exceptionHandler异常统一处理的方法所用的注解
	 * responseBody返回json格式
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value=Exception.class	)
	public Map<String,Object> errorHandler(Exception ex){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", -1);
		map.put("msg", ex.getMessage());
		return map;
	}
	
	/**
	 * 自定义异常捕获统一处理
	 * BusinessException自定义异常类
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value=BusinessException.class	)
	public Map<String,Object> errorHandler(BusinessException ex){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", ex.getCode());
		map.put("msg", ex.getMsg());
		return map;
	}
}
