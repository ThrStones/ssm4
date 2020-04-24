package com.galaxy.service.impl;

import com.galaxy.dao.MeetingDao;
import com.galaxy.entity.Meeting;
import com.galaxy.service.MeetingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Resource
    private MeetingDao meetingDao;

    @Override
    public List<Meeting> queryAllByPage(int pageNum, int pageSize, Meeting meeting) {

        PageHelper.startPage(pageNum, pageSize);
        List<Meeting> meetingList = meetingDao.queryAllByPage(meeting);
        new PageInfo<Meeting>(meetingList);

        return meetingList;
    }

    @Override
    public Map<String, Integer> queryTotalPage(int pageSize, Meeting meeting) {
        HashMap<String, Integer> countMap = new HashMap<>();
        int totalCount = meetingDao.queryTotalCount(meeting);
        int totalPage = totalCount % pageSize > 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
        countMap.put("totalCount", totalCount);
        countMap.put("totalPage", totalPage);
        return countMap;
    }

    @Override
    public void insert(Meeting meeting) {
        meetingDao.insert(meeting);
    }

    @Override
    public void delete(int[] ids) {
        for (int id : ids) {
            meetingDao.delete(id);
        }
    }

    @Override
    public Meeting queryById(int id) {
        return meetingDao.queryById(id);
    }

    @Override
    public int update(Meeting meeting) {
        return meetingDao.update(meeting);
    }
}
