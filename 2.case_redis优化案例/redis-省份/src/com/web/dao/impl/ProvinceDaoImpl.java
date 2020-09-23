package com.web.dao.impl;

import com.web.dao.ProvinceDao;
import com.web.domain.Province;
import com.web.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    //声明成员变量jdbctemplate
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {

        //1.定义sql
        String sql = "select * from province";
        //执行sql
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        System.out.println(list);
        return list;
    }

/*    @Test
    public void test1(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        System.out.println(jdbcTemplate);
    }*/
}
