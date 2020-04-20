package com.galaxy.dao;

import com.galaxy.entity.Dept;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao {

    @Select("select * from dept")
    public List<Dept> queryAllByPage();

    @Select("select count(*) from dept")
    public int queryTotalCount();

}
