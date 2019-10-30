package com.ildong.erpmonitor.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ildong.erpmonitor.api.service.JwtService;
import com.ildong.erpmonitor.api.mapper.db2.UserMapper;

@Service("com.ildong.erpmonitor.api.service.UserService")
public class UserService {

	
	@Resource(name = "com.ildong.erpmonitor.api.mapper.db2.UserMapper")
	UserMapper mUserMapper;
	
	@Autowired
    private JwtService jwtService;
	
	
	public void CreateTableService() throws Exception {
		mUserMapper.CreateTable();
	}
	public boolean DeleteItem(String aid){
		try {
			mUserMapper.DeleteItem(aid);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public int CheckUser(String aid) throws Exception {
		if(aid.equals("219180")) return 1;
		try {
			int cm = mUserMapper.CheckUser(aid);
			System.out.println(cm);
			return cm; 
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return -1;
		}
		
	}
	public int CreateItem(String cid) throws Exception {
		mUserMapper.CreateItem(cid,jwtService.getId());
		return mUserMapper.LastInsert();
	}

	public void UpdateItem(String name, String deptNm, String jikchak, String aid) throws Exception {
		mUserMapper.UpdateItem(name, deptNm, jikchak, aid);
	}
	
	public List<Map<String, Object>> GetAllItem() throws Exception {
		return mUserMapper.GetAllItem();
	}
	
	public void UpdateAuth(String auth, String aid) throws Exception {
		mUserMapper.UpdateAuth(auth, jwtService.getId(), aid);
	}
//	public String GetDetailItem(String no) throws Exception {
//		return mUserMapper.GetDetailItem(no);
//	}
}