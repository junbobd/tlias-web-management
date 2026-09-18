package com.it_study.service.Impl;

import com.it_study.mapper.DeptMapper;
import com.it_study.mapper.EmpMapper;
import com.it_study.pojo.Dept;
import com.it_study.pojo.DeptLog;
import com.it_study.service.DeptLogService;
import com.it_study.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;



    //查询部门
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }



    //删除部门
    @Transactional(rollbackFor = Exception.class)//添加事务管理，并指定所有异常都会回滚
    @Override
    public void delete(Integer id) {
        try {
            deptMapper.deleteById(id);
            //根据部门id删除员工
            empMapper.deleteByDeptId(id);


        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }

    }

    //新增部门
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());

        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
    //根据id查找部门
    @Override
    public Dept getById(Integer id) {
        Dept dept = deptMapper.getById(id);
        return dept;

    }
    //修改部门
    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }


}
