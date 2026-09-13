package com.it_study.service;

import com.it_study.pojo.Dept;

import java.util.List;

public interface DeptService {
    //查询部门
    List<Dept> list();
    //删除部门
    void delete(Integer id);
    //新增部门
    void add(Dept dept);
    //根据id查部门
    Dept getById(Integer id);
    //修改部门
    void update(Dept dept);


}
