package controller;

import model.Orders;
import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.OrdersService;
import service.UsersService;

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

    @RequestMapping("/orders/{id}")
    public Orders getB(@PathVariable Long id){
        return ordersService.selectById(id);
    }

}
