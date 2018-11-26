package com.company.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.company.valid.group.ValidGroupDefault;
import com.company.valid.group.ValidGroupUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author guofa.liu
 * @create 2018/11/15 15:16
 * @description
 */

@Data
public class Users {

    @NotNull(groups = ValidGroupUpdate.class, message = "id不能为空")
    private Long id;

    @NotBlank(groups = {ValidGroupDefault.class}, message = "用户名不能为空")
    private String name;

    @NotNull(groups = {ValidGroupDefault.class}, message = "年龄不能为空")
    @Range(groups = {ValidGroupDefault.class}, min = 1,max = 100,message = "年龄不在范围内")
    private Integer age;

    private String email;

    @TableField("create_time")
    private Date createTime;
}
