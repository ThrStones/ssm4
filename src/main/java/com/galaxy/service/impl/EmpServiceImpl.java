package com.galaxy.service.impl;

import com.galaxy.dao.EmpDao;
import com.galaxy.entity.Emp;
import com.galaxy.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpDao empDao;

    @Override
    public List<Emp> queryAllByPage(int pageNum, int pageSize, Emp emp) {
        PageHelper.startPage(pageNum, pageSize);
        List<Emp> empList = empDao.queryAllByPage(emp);
        new PageInfo<Emp>(empList);
        return empList;
    }

    @Override
    public Map<String, Integer> queryTotalPage(int pageSize, Emp emp) {
        int totalCount = empDao.queryTotalCount(emp);
        int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;

        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("totalCount", totalCount);
        countMap.put("totalPage", totalPage);

        return countMap;
    }

    @Override
    public void insert(Emp emp) {
        String eNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        emp.seteNo(eNo);
        emp.setState("正常");
        empDao.insert(emp);
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            empDao.delete(id);
        }
    }

    @Override
    public Emp queryById(int id) {
        return empDao.queryById(id);
    }

    @Override
    public int update(Emp emp) {
        return empDao.update(emp);
    }
}
