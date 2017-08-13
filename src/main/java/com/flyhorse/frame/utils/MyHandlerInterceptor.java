package com.flyhorse.frame.utils;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerInterceptor implements HandlerInterceptor{
	
	static Logger logger = LoggerFactory.getLogger(MyHandlerInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception arg3) throws Exception {
		logger.info("拦截器的完成方法执行了");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView ma) throws Exception {
		logger.info("拦截器后置方法执行了");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String url = request.getRequestURI();
		if("/citi_log/login/initLogin.action".equals(url) //demo 配置需要拦截的url
		   || "/citi_log/login/getLoginInfo.action".equals(url)
		   || "/citi_log/login/transMoney.action".equals(url)
		){
			return true; 
		}else{
			//如果页面不是请求登录的时候，做session验证
			Object obj = request.getSession().getAttribute("username");
			logger.info(obj!=null?obj.toString():"obj is null");
			if(obj != null){
				logger.info("验证成功");
				return true;
			}else{
				if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
					PrintWriter out = response.getWriter();  
		            out.print("loseSession");
		            out.flush();
					return false;
				}
				logger.info("验证失败");
				response.sendRedirect("/citi_log/login/initLogin.action");
				return false;
			}
		}
		/*return true;*/
	
	}
}