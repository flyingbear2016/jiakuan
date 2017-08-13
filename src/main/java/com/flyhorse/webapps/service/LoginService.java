package com.flyhorse.webapps.service;

import java.util.List;
import java.util.Map;

public interface LoginService {
	
	List<Map<String,Object>>  queryLoginInfo(String id);
	
	List<Map<String,Object>>  getBlanceList();
	
	void transMoney(Map<String,Object> map);

}
