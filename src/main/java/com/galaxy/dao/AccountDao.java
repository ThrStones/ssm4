package com.galaxy.dao;

import com.galaxy.entity.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {

    @Select("select * from account where name=#{name} and password=#{password}")
    public Account login(Account account);

    @Select("select * from account where id=#{id}")
    public Account queryById(int id);

}
