package com.galaxy.service.impl;

import com.galaxy.dao.TestBeanDao;
import com.galaxy.entity.TestBean;
import com.galaxy.service.TestBeanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestBeanServiceImpl implements TestBeanService {

    @Resource
    private TestBeanDao testBeanDao;

    @Override
    public void insert(TestBean testBean) {
        testBeanDao.insert(testBean);
    }

    @Override
    public void delete(int id) {
        testBeanDao.delete(id);
    }

    @Override
    public void update(TestBean testBean) {
        testBeanDao.update(testBean);
    }

    @Override
    public TestBean queryById(int id) {
        return testBeanDao.queryById(id);
    }

    @Override
    public int queryTotalPages(int pageSize) {
        int totalCount = testBeanDao.queryTotalCount();
        int totalPages = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
        return totalPages;
    }

    @Override
    public List<TestBean> queryAllByPages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TestBean> testBeanList = testBeanDao.queryAllByPages();
        new PageInfo<TestBean>(testBeanList);
        return testBeanList;
    }
}
