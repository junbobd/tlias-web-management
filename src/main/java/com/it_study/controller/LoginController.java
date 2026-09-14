package com.it_study.controller;

import com.it_study.pojo.Emp;
import com.it_study.pojo.Result;
import com.it_study.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@RestController = @Controller + @ResponseBody
public class LoginController {
    //注入Service
    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        Emp e = empService.login(emp);
        return e!=null?Result.success():Result.error("用户名或密码错误");
    }
}
