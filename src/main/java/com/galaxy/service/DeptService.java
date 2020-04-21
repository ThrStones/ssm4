package com.galaxy.service;

import com.galaxy.entity.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {

    public List<Dept> queryAllByPage(int pageNum, int pageSize,String name);

    public Map<String,Integer> queryTotalPage(int pageSize,String name);

    public void insert(Dept dept);

    public void delete(int[] ids);

    public Dept queryById(int id);

    public int update(Dept dept);

}
