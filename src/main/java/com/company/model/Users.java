package com.company.model;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

/**
 * @author guofa.liu
 * @create 2018/11/15 15:16
 * @description
 */
public class Users {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField("create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
