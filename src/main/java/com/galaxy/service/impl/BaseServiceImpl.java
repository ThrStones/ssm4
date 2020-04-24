package com.galaxy.service.impl;

import com.galaxy.service.BaseService;

import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> implements BaseService<T> {

    //1、如何引入Dao来进行操作
    //2、哪些方法是可以用通用方法的
    //3、不能使用通用方法的，怎么处理，单独写？还是其他方法？

    @Override
    public List queryAllByPage(int pageNum, int pageSize, T t) {

        return null;
    }

    @Override
    public Map<String, Integer> queryTotalPage(int pageSize, T t) {
        return null;
    }

    @Override
    public void insert(T t) {

    }

    @Override
    public void delete(int[] ids) {

    }

    @Override
    public T queryById(int id) {
        return null;
    }

    @Override
    public int update(T t) {
        return 0;
    }
}
