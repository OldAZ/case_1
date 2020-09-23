package com.web.test;

import com.web.jdbc.JdbcUtil;
import com.web.pojo.Dept;
import com.web.pojo.Emps;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Emps emps = new Emps();
        emps.setAge(15);
        emps.setId(001);

    }


    @Test
    public void test1(){
        // 1.获取某个类的实体类对象：三种方式
        Class<Emps> c1 = Emps.class;
        Class<?extends Emps> c2 = new Emps().getClass();
        try {
            Class<?> c3 = Class.forName("com.web.pojo.Emps");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.分别对实体类的成员（属性，方法，构造方法）进行托管
    }

    @Test//使用构造器管理实体类中的构造方法
    public void test2() throws Exception {
        // 1.获取class对象对象：三种方式
        Class<Emps> c1 = Emps.class;

        //2.获取构造方法的管理类
            //2.1托管无参构造
            Emps emps =  c1.newInstance();

            //2.2托管有参构造
        Constructor<Emps> Constructor = c1.getDeclaredConstructor(Integer.class, String.class);
        Emps emps1 = Constructor.newInstance(1, "元歌");
        System.out.println(emps);
        System.out.println(emps1);
    }




    @Test//使用field类，来管理实体类中的某个属性
    public void test3() throws Exception {
        // 1.获取class对象对象：三种方式
        Class<Emps> c1 = Emps.class;

        //2.获取某个属性的管理类Field
        Field f1 = c1.getDeclaredField("name");
        Field f2 = c1.getDeclaredField("age");
        Emps emps = c1.newInstance();
        //3.开启私有属性的操作权限
        f1.setAccessible(true);
        f2.setAccessible(true);


        System.out.println(emps);
        f1.set(emps,"孙尚香");
        f2.set(emps,18);
        System.out.println(emps);
    }


    @Test//使用Method类，来管理实体类中的某个方法
    public void test4() throws Exception {
        // 1.获取class对象对象
        Class<Emps> c1 = Emps.class;

        //2.获取某个方法的管理类Method
        Method method = c1.getDeclaredMethod("setName", String.class);
        Emps emps = c1.newInstance();
        System.out.println(emps);
        method.invoke(emps,"韩信");
        System.out.println(emps);

        System.out.println("--------调用toString------");
        Method method1 = c1.getDeclaredMethod("toString");
        Object invoke = method1.invoke(emps);
        System.out.println(invoke);

    }

    @Test
    public void test5(){
        //测试jdbc工具类
        List<Emps> emps = JdbcUtil.rsToList("select * from emps", Emps.class);
        System.out.println(emps);
    }


    @Test
    public void test6(){
            //测试jdbc工具类
            List<Dept> dept = JdbcUtil.rsToList("select * from dept", Dept.class);
            System.out.println(dept);
    }
}
