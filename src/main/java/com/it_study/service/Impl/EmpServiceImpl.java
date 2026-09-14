package com.it_study.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.it_study.mapper.EmpMapper;
import com.it_study.pojo.Emp;
import com.it_study.pojo.PageBean;
import com.it_study.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //1.获取总记录数
//        Long count = empMapper.count();
//        //2.获取查询结果列表
//        Integer start = (page-1)*pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//        //3.封装pageBean对象
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end) {

        //1.设置分页参数
        PageHelper.startPage(page,pageSize);
        //2.执行查询
        List<Emp> empList = empMapper.list(name,gender,begin,end);
        Page<Emp> p= (Page<Emp>) empList;
        //3.封装pageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    //删除
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    //新增
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
    //根据id查询
    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    //修改员工信息
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    //登录
    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }
}
