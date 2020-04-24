package com.galaxy.service;

import com.galaxy.entity.Meeting;

import java.util.List;
import java.util.Map;

public interface MeetingService {

    public List<Meeting> queryAllByPage(int pageNum, int pageSize, String title);

    public Map<String,Integer> queryTotalPage(int pageSize, String title);

    public void insert(Meeting meeting);

    public void delete(int[] ids);

    public Meeting queryById(int id);

    public int update(Meeting meeting);

}
