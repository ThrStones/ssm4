package com.galaxy.service;

import com.galaxy.entity.TestBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TestBeanService {

    public void insert(TestBean testBean);

    public void delete(int id);

    public void update(TestBean testBean);

    public TestBean queryById(int id);

    public int queryTotalPages(int pageSize);

    public List<TestBean> queryAllByPages(int pageNum, int pageSize);

}
