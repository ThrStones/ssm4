package com.galaxy.service.impl;

import com.galaxy.dao.BaseDao;
import com.galaxy.entity.Dept;
import com.galaxy.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    //1、如何引入Dao来进行操作
    //2、哪些方法是可以用通用方法的--所有
    //3、不能使用通用方法的，怎么处理，单独写？还是其他方法？--单独写

    @Resource
    private BaseDao<T> baseDao;

    @Override
    public void delete(int[] ids, String tableName) {
        System.out.println("调用的是通用的删除方法！");
        for (int id : ids) {
            baseDao.delete(id, tableName);
        }
    }

    @Override
    public T queryById(int id) {
        return null;
    }

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
    public int update(T t) {
        return 0;
    }
}
