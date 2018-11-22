package com.company.controller;

import com.company.common.R;
import com.company.model.Users;
import com.company.valid.group.ValidGroupAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.service.OrdersService;
import com.company.service.UsersService;

import javax.validation.Valid;


/**
 * @author guofa.liu
 * @create 2018/11/15 14:37
 * @description
 */

@RestController
@RequestMapping("base")
@Validated
public class BaseController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private OrdersService ordersService;


    @RequestMapping("/users/{id}")
    public R.ResponseData getUsers(@PathVariable Long id){
        return R.success(usersService.selectById(id));
    }

    @RequestMapping("/users/add")
    @Validated(ValidGroupAdd.class)
    public R.ResponseData addUsers(@Valid Users users){
        usersService.insert(users);
        return R.success();
    }

    @RequestMapping("/users/{pageNum}/{pageSize}")
    public R.ResponseData getUsers(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        return R.success(usersService.selectAllPage(pageNum, pageSize));
    }

    @RequestMapping("/orders/{id}")
    public R.ResponseData getOrders(@PathVariable Long id){
        return R.success(ordersService.selectById(id));
    }

}
