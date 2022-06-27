package com.lili.p2.bean;

//model层
public class Customer {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String phone;
    private String email;

    public Customer(){}
    public Customer(int id,String name,String sex,int age,String tel,String mail){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.phone=tel;
        this.email=mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    //    public

    public static void main(String[] args) {
        int a=5;
        Customer zhangsan=new Customer();
        Customer lisi=new Customer(1,"李四","男",22,"123456","122qq.com");
        System.out.println("断点");

    }

}
