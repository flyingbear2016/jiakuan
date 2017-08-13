package com.flyhorse.webapps.dao;

import java.util.List;
import java.util.Map;

public interface LoginDao {
	
	
	List<Map<String, Object>>  queryLoginInfo(long id);
	
	List<Map<String, Object>>  getBalanceList();
	
	int transOut(Map<String,Object> map);
	 
	int transIn(Map<String,Object> map);
	 

}
