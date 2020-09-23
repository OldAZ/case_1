package com.web.pojo;

public class Dept {
    private Integer did;
    private String dname;
    private String location;

    //无参
    public Dept() {
    }

    public Dept(Integer did, String dname, String location) {
        this.did = did;
        this.dname = dname;
        this.location = location;
    }
//有参构造
    @Override
    public String toString() {
        return "dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
//getter和setter

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
