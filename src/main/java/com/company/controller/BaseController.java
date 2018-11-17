package com.company.controller;

import com.company.common.Page;
import com.company.model.Orders;
import com.company.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.company.service.OrdersService;
import com.company.service.UsersService;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:37
 * @description
 */

@RestController
@RequestMapping("base")
public class BaseController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private OrdersService ordersService;


    @RequestMapping("/users/{id}")
    public Users getUsers(@PathVariable Long id){
        return usersService.selectById(id);
    }

    @RequestMapping("/users/add")
    public Boolean addUsers(Users users){
        usersService.insert(users);
        return true;
    }

    @RequestMapping("/users/{pageNum}/{pageSize}")
    public Page<Users> getUsers(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        return usersService.selectAllPage(pageNum, pageSize);
    }

    @RequestMapping("/orders/{id}")
    public Orders getOrders(@PathVariable Long id){
        return ordersService.selectById(id);
    }

}
