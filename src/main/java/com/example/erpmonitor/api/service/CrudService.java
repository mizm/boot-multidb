package com.ildong.erpmonitor.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ildong.erpmonitor.api.mapper.db2.CrudMapper;
import com.ildong.erpmonitor.api.service.JwtService;

@Service("com.ildong.erpmonitor.api.service.CrudService")
public class CrudService {

	@Autowired
    private JwtService jwtService;
	
	@Resource(name = "com.ildong.erpmonitor.api.mapper.db2.CrudMapper")
	CrudMapper mCrudMapper;
	
	public void CreateTableService() throws Exception {
		mCrudMapper.CreateTable();
	}
	public boolean DeleteItem(String no){
		try {
			mCrudMapper.DeleteItem(no);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public int CreateItem(String title, String query, String varlist) throws Exception {
		mCrudMapper.CreateItem(title,query,varlist,jwtService.getId());
		return mCrudMapper.LastInsert();
	}

	public void UpdateItem(String title, String query, String no, String varlist) throws Exception {
		mCrudMapper.UpdateItem(title,query,no,varlist,jwtService.getId());
	}
	
	public List<Map<String, Object>> GetAllItem() throws Exception {
		return mCrudMapper.GetAllItem();
	}
	
	public String GetDetailItem(String no) throws Exception {
		return mCrudMapper.GetDetailItem(no);
	}
}