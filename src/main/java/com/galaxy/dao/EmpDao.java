package com.galaxy.dao;

import com.galaxy.entity.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDao {

    @Select("<script>" +
            "select * from emp " +
            "<where> " +
            "<if test=\"eNo!=null and eNo!= ''\">" +
            "<bind name=\"empNo\" value=\"'%'+eNo+'%'\"/>" +
            " and eNo like #{empNo}" +
            "</if><if test=\"name!=null and name!=''\">" +
            "<bind name=\"dName\" value=\"'%'+name+'%'\"/>" +
            " and name like #{dName}" +
            "</if></where>  order by id desc" +
            "</script>")
    public List<Emp> queryAllByPage(Emp emp);

    @Select("<script>" +
            "select count(*) from emp " +
            "<where> " +
            "<if test=\"eNo!=null and eNo!= ''\">" +
            "<bind name=\"empNo\" value=\"'%'+eNo+'%'\"/>" +
            " and eNo like #{empNo}" +
            "</if><if test=\"name!=null and name!=''\">" +
            "<bind name=\"dName\" value=\"'%'+name+'%'\"/>" +
            " and name like #{dName}" +
            "</if></where>  order by id desc" +
            "</script>")
    public int queryTotalCount(Emp emp);

    @Insert("insert into emp values (0, #{eNo}, #{name}, #{sex}, #{phone}, #{dept}, #{role}, #{state})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(Emp emp);

    @Delete("delete from emp where id=#{id}")
    public void delete(int id);

    @Select("select * from emp where id=#{id}")
    public Emp queryById(int id);

    @Update("update emp set name=#{name}, sex=#{sex}, phone=#{phone}, dept=#{dept}, role=#{role}, state=#{state} where id=#{id}")
    public int update(Emp emp);

}
