package com.flyhorse.webapps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyhorse.webapps.dao.LoginDao;
import com.flyhorse.webapps.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public List<Map<String, Object>> queryLoginInfo(String id) {
		Long ids = Long.parseLong(id);
		List<Map<String, Object>> result = loginDao.queryLoginInfo(ids);
		return result;
	}
	
	
	public List<Map<String, Object>> getBlanceList() {
		List<Map<String, Object>> result = loginDao.getBalanceList();
		return result;
	}
	
	@Transactional
	public void transMoney(Map<String,Object> map){
		String outIds = map.get("outIds")!=null?map.get("outIds").toString():"";
		String inIds = map.get("inIds")!=null?map.get("inIds").toString():"";
		String moneys = map.get("moneys")!=null?map.get("moneys").toString():"";
		Long outId = Long.parseLong(outIds);
		Long inId = Long.parseLong(inIds);
		Integer money = Integer.valueOf(moneys);
		
		Map<String,Object> out = new HashMap<String,Object>();
		out.put("outId", outId);
		out.put("money", money);
		Map<String,Object> in = new HashMap<String,Object>();
		in.put("inId", inId);
		in.put("money", money);
		
		
		int o = loginDao.transOut(out);
		System.out.println("==========准备抛异常---------");
		System.out.println(1/0);//模拟断电
		int i = loginDao.transIn(in);
	}

	

}
