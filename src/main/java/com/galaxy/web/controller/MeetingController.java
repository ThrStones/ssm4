package com.galaxy.web.controller;

import com.galaxy.entity.Account;
import com.galaxy.entity.Meeting;
import com.galaxy.service.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("meeting")
public class MeetingController extends BaseController{

    @Resource
    private MeetingService meetingService;

    @GetMapping("meetingList")
    public String meetingList(int pageNum, String title, Model model){
        List<Meeting> meetingList = meetingService.queryAllByPage(pageNum,pageSize, title);
        model.addAttribute("meetingList",meetingList);
        Map<String, Integer> countMap = meetingService.queryTotalPage(pageSize, title);
        model.addAttribute("countMap",countMap);
        model.addAttribute("pageNum",pageNum);
        return "meeting/meetingList";
    }

    @GetMapping("insertPage")
    public String insertPage(){
        return "meeting/meetingInsert";
    }


    @PostMapping("insert")
    public String insert(Meeting meeting, Model model, HttpSession session){
        //方法一：在后台， 获取Session
//        Account loginAccount = (Account) session.getAttribute("loginAccount");
//        meeting.setAccountId(loginAccount.getId());
        //方法二：在前台， 获取Session，封装到meeting对象中
        meetingService.insert(meeting);
        if (meeting.getId()>0){
            return "redirect:meetingList?pageNum=1";
        } else {
            model.addAttribute("errorMsg","添加失败！！");
            model.addAttribute("meeting",meeting);
            return "meeting/meetingInsert";
        }
    }

    @PostMapping("delete")
    public String delete(int[] ids){
        meetingService.delete(ids);
        return "redirect:meetingList?pageNum=1";
    }

    @GetMapping("queryById")
    public String queryById(int ids,Model model){
        Meeting meeting = meetingService.queryById(ids);
        model.addAttribute("meeting",meeting);
        return "meeting/meetingUpdate";
    }

    @PostMapping("update")
    public String update(Meeting meeting,Model model){
        int count = meetingService.update(meeting);
        //count = 0;
        if (count>0){
            //修改成功
            return "redirect:meetingList?pageNum=1";
        } else {
            //修改失败
            model.addAttribute("errorMsg","修改失败！！");
            model.addAttribute("meeting",meeting);
            return "meeting/meetingUpdate";
        }
    }

}
