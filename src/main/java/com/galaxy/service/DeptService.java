package com.galaxy.service;

import com.galaxy.entity.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {

    public List<Dept> queryAllByPage(int pageNum, int pageSize);

    public Map<String,Integer> queryTotalPage(int pageSize);

}
