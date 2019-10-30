package com.ildong.erpmonitor.api.service;

import com.ildong.erpmonitor.api.mapper.db1.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("com.ildong.erpmonitor.api.service.BoardService")
public class BoardService {

    @Resource(name = "com.ildong.erpmonitor.api.mapper.db1.BoardMapper")
    BoardMapper mBoardMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

        //login
    public List<Map<String, Object>> LoginService(String userId) throws Exception {

        return mBoardMapper.login(userId);
    }

    //select 전용
    public List<Map<String, Object>> apiTest(String query) throws Exception {
        return jdbcTemplate.queryForList(query);
    }
}