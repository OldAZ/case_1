package com.web.Jedis.test;


import com.web.Jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author OldAZ-PC
 * jedis的测试类
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1() {
        //1.获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("username", "shangsan");
        //3.关闭连接
        jedis.close();
    }


    /**
     * String数据
     */
    @Test
    public void test2() {
        //1.获取连接
        //如果使用空参构造，默认值 “localhost”，6379
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("username", "shangsan");
        System.out.println(jedis.get("username"));

        //可以使用setext（）方式储存过期时间的key value
        // 将actived：hehe 键值对存入redis，并且20秒以后自动删除键值对
        jedis.setex("actived", 20, "hehe");


        //3.关闭连接
        jedis.close();
    }


    /**
     * Hash数据结构
     */
    @Test
    public void test3() {
        //1.获取连接
        //如果使用空参构造，默认值 “localhost”，6379
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作

        //存储hash
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "24");
        jedis.hset("user", "gender", "male");

        //获取 hash
        System.out.println(jedis.hget("user", "name"));

        //获取hah的所有map中的元素
        Map<String, String> user = jedis.hgetAll("user");
        System.out.println(user);
        //遍历
        Set<String> keys = user.keySet();
        for (String key : keys) {
            //获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);

        }
        //3.关闭连接
        jedis.close();
    }


    /**
     * list数据结构
     */
    @Test
    public void test4() {
        //1.获取连接
        //如果使用空参构造，默认值 “localhost”，6379
        Jedis jedis = new Jedis();
        //2.操作

        //存储数据
        jedis.lpush("mylist", "a", "b", "c", "d");//从左边存
        jedis.rpush("mylist", "a", "b", "c", "d");//从右边存
        //获取数据
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //list弹出
        String lpop = jedis.lpop("mylist");
        System.out.println(lpop);

        String rpop = jedis.rpop("mylist");
        System.out.println(rpop);

        //3.关闭连接
        jedis.close();
    }


    /**
     * set数据结构
     */
    @Test
    public void test5() {
        //1.获取连接
        //如果使用空参构造，默认值 “localhost”，6379
        Jedis jedis = new Jedis();
        //2.操作

        //存储数据
        jedis.sadd("myset", "java", "php", "c++");
        //获取数据
        System.out.println(jedis.smembers("myset"));

        //3.关闭连接
        jedis.close();
    }


    /**
     * sortedset数据结构
     */
    @Test
    public void test6() {
        //1.获取连接
        //如果使用空参构造，默认值 “localhost”，6379
        Jedis jedis = new Jedis();
        //2.操作

        //存储数据
        jedis.zadd("mysortedset", 1, "老赵");
        jedis.zadd("mysortedset", 2, "老钱");
        jedis.zadd("mysortedset", 3, "老孙");
        jedis.zadd("mysortedset", 4, "老王");
        //获取数据
        System.out.println(jedis.zrange("mysortedset", 0, -1));

        //3.关闭连接
        jedis.close();
    }


    /**
     * jedis连接池的使用
     */
    @Test
    public void test7() {
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(50);


        //1.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();

        //3.使用
        jedis.set("hehe", "haha");

        //关闭，归还到连接池中
        jedis.close();
    }



    /**
     * jedis连接池工具类的使用
     */
    @Test
    public void test8() {
      //通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        //使用
        jedis.set("hello", "world");

        //关闭，归还连接池

        jedis.close();
    }

}