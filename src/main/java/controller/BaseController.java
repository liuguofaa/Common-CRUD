package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AService;
import service.BService;
import service.CService;

/**
 * @author guofa.liu
 * @create 2018/11/15 14:37
 * @description
 */

@RestController
@RequestMapping("base")
public class BaseController {

    @Autowired
    private AService aService;
    @Autowired
    private BService bService;
    @Autowired
    private CService cService;


    @RequestMapping("/a")
    public String getA(){
        return aService.get();
    }

    @RequestMapping("/b")
    public String getB(){
        return bService.get();
    }

    @RequestMapping("/c")
    public String getC(){
        return cService.get();
    }

}
