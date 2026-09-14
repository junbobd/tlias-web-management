package com.it_study.service;

import com.it_study.pojo.Emp;
import com.it_study.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize,
                  String name, Short gender,
                  LocalDate begin, LocalDate end);

    //删除
    void delete(List<Integer> ids);

    //新增
    void save(Emp emp);

    //根据id查询
    Emp getById(Integer id);

    //修改员工信息
    void update(Emp emp);

    //登录
    Emp login(Emp emp);
}
