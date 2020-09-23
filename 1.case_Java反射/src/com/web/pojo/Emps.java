package com.web.pojo;

public class Emps {

    //数据库属性
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Double salary;
    private Integer dept_id;

    //重写toString方法
    @Override
    public String toString() {
        return "Emps{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                '}';
    }

    //不带参数的构造方法

    public Emps() {
        System.out.println("无参构造");
    }

    //带两个参数的构造方法
    public Emps(Integer id, String name) {
        System.out.println("两个参数的有参构造");
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //getter和setter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }
}
