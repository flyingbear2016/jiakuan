package com.flyhorse.webapps.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyhorse.frame.utils.PropertiesUtil;
import com.flyhorse.webapps.service.LoginService;

@Controller
@RequestMapping(value = "login")
public class LoginController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "initLogin",method = RequestMethod.GET)
	public String initLogin(HttpServletRequest request,
			HttpServletResponse response) {
		return "views/page/login";
	}
	
	/*@RequestMapping(value="indexJsp")
	public String indexJsp(HttpServletRequest request,
			HttpServletResponse response){
		return "views/page/index";
	}*/
	
	
	@RequestMapping(value = "getLoginInfo",method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String,Object>> getLoginInfo(@RequestParam String id){
		String resourcePath = PropertiesUtil.getResourcePath();
		System.out.println(resourcePath);
		List<Map<String,Object>> result = loginService.queryLoginInfo(id);
		
		return result;
	}
	
	@RequestMapping(value = "getBalanceList",method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String,Object>> getBalanceList(){
		List<Map<String,Object>> result = loginService.getBlanceList();
		
		return result;
	}
	
	
	@RequestMapping(value = "transMoney",method = RequestMethod.POST)
	@ResponseBody
	public void transMoney(@RequestParam(value = "jsonParam") String jsonParam) throws Exception{
		Map<String, Object> map = objectMapper.readValue(jsonParam, Map.class);
		
		loginService.transMoney(map);
		
	}
	

}
