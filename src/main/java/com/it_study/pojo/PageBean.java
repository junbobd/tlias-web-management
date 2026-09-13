package com.it_study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//分页查询结果的封装类
public class PageBean {
    private Long total;//总数据数
    private List rows;//数据列表

}
