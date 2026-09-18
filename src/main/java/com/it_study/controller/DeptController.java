package com.it_study.controller;

import com.it_study.anno.Log;
import com.it_study.pojo.Dept;
import com.it_study.pojo.Result;
import com.it_study.service.DeptService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController

@RequestMapping("/depts")
public class DeptController {


    @Autowired
    private DeptService deptService;
    //部门查询
//    @RequestMapping("/depts",method= RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询全部部门信息");
        List<Dept> deptList= deptService.list();
        return Result.success(deptList);
    }

    //删除部门
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("按照id删除部门:{}",id);
        deptService.delete(id);
        return Result.success();
    }

    //新增部门
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据id查询
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查找部门:{}",id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改部门
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门:{}",dept);
        deptService.update(dept);
        return Result.success();
    }


}
