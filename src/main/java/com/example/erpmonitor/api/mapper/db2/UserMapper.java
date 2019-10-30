package com.ildong.erpmonitor.api.mapper.db2;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository("com.ildong.erpmonitor.api.mapper.db2.UserMapper")
public interface UserMapper {
 
//    List <Map<String,Object>> test(String userName) throws Exception;
    void CreateTable() throws Exception;
    void CreateItem(String cid, String aid) throws Exception;
    void UpdateItem(String name, String deptNm,String jikchak,String aid) throws Exception;
    void UpdateAuth(String auth,String cid, String aid) throws Exception;
    int LastInsert() throws Exception;
    List <Map<String,Object>> GetAllItem() throws Exception;
    void DeleteItem(String aid);
    int CheckUser(String aid) throws Exception;
    
}
 


