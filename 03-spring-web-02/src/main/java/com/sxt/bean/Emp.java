package com.sxt.bean;

public class Emp {

    private String address;

    private String name;

    private Integer age;

    public Emp() {

    }

    public Emp(String address) {
        this.address = address;
    }

    public Emp(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Emp(String address, String name, Integer age) {
        super();
        this.address = address;
        this.name = name;
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Emp [address=" + address + ", name=" + name + ", age=" + age + "]";
    }

}
