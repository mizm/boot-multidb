package com.ildong.erpmonitor.api.mapper.db2;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository("com.ildong.erpmonitor.api.mapper.db2.CrudMapper")
public interface CrudMapper {
 
//    List <Map<String,Object>> test(String userName) throws Exception;
    void CreateTable() throws Exception;
    void CreateItem(String title, String query, String varlist, String cid) throws Exception;
    void UpdateItem(String title, String query, String no, String varlist, String cid) throws Exception;
    int LastInsert() throws Exception;
    List <Map<String,Object>> GetAllItem() throws Exception;
    void DeleteItem(String no);
    String GetDetailItem(String no) throws Exception;
    
}
 


