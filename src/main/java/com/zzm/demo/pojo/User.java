package com.zzm.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;


@Document
public class User implements Serializable{
    @Id
    private String id;  //自定义id
//    @Indexed
    private String uuid; //使用索引
    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    @Transient
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getAddress() {
        return address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
