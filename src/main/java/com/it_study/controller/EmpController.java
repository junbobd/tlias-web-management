package com.it_study.controller;

import com.it_study.anno.Log;
import com.it_study.pojo.Emp;
import com.it_study.pojo.PageBean;
import com.it_study.pojo.Result;
import com.it_study.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps" )
public class EmpController {
    @Autowired
    private EmpService empService;

    //查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,//这个注解可以设置参数的默认值
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate begin, //该注解用于指定接受日期的格式
                       @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end){
        log.info("分页查询，参数：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        PageBean pageBean =empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    //删除员工
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("执行批量删除操作,{}",ids);
        empService.delete(ids);

        return Result.success();
    }

    //新增员工
    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("增加员工，emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    //根据id查询
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询员工,id为：{}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    //修改数据
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息:{}",emp);
        empService.update(emp);
        return Result.success();
    }

}
