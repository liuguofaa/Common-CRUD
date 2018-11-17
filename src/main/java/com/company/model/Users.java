package com.company.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author guofa.liu
 * @create 2018/11/15 15:16
 * @description
 */

@Data
public class Users {

    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField("create_time")
    private Date createTime;
}
