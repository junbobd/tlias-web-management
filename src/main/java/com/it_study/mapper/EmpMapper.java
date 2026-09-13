package com.it_study.mapper;

import com.it_study.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.sql.autoconfigure.init.ConditionalOnSqlInitialization;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    //获取总记录数
//    @Select("select count(*) from emp")
//    public Long count();
//
//    //分页查询-获取列表数据
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

//    @Select("select * from emp")


    public List<Emp> list(
            String name,
            Short gender,
            LocalDate begin,
            LocalDate end);

    //删除
    void delete(List<Integer> ids);

    //新增
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //根据id查询
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    //修改员工
    void update(Emp emp);
}
