package com.zzm.demo.pojo;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${sq} on 2017/9/25.
 */
public class DemoInfo implements Serializable{

    //id属性是给mongodb用的，用@Id注解修饰
    @Id
    private String id;

    private String name;

    private int age;

    private int money;

    private List<String> list;


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int getMoney() {
        return money;
    }


    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DemoInfo [id=" + id + ", name=" + name + ",age=" + age + "]";
    }
}
