package com.web.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.Jedis.util.JedisPoolUtils;
import com.web.dao.ProvinceDao;
import com.web.dao.impl.ProvinceDaoImpl;
import com.web.domain.Province;
import com.web.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /*
    * 使用Redis的缓存
    * */
    @Override
    public String findAllJson() {
        //1.先从Redis中查询数据
        //1.1 获取Redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String provice_json = jedis.get("province");

        //2.判断province——json是否为null
        if (provice_json == null||provice_json.length()==0) {
            //redis中没有数据
            System.out.println("redis中没有数据，查询数据库。。。");
            //2.1从数据库中查询
            List<Province> ps = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                provice_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3将数据存入redis
            jedis.set("province",provice_json);
            //归还连接
            jedis.close();

        }else {
            System.out.println("redis中有数据，查询缓存");
        }



        return provice_json;
    }

}