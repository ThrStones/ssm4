package com.galaxy.web.controller;

import com.galaxy.entity.Dept;
import com.galaxy.service.DeptService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("dept")
@PropertySource("classpath:db.properties")
public class DeptController {

    @Value("${mybatis.pageHelper.size}")
    int pageSize;

    @Resource
    private DeptService deptService;

    @GetMapping("deptList")
    public String deptList(int pageNum, String name, Model model){

        //分页查询部门信息
        /*
         * 思路：
         * 1、获取页面需要查询的页码pageNum
         * 2、使用pageHelper来分页，读取db.properties中的每页显示的条数pageSize
         * 		在类上添加注解@PropertySource("classpath:db.properties")
         * 		使用@Value注解获取值
         * 3、调用Service(注入)，并在Service中进行调用Dao及分页操作
         * 		@Resource注入Dao
         * 		PageHelper.StartPage(pageNum,pageSize);
         *		调用Dao查询
         *		new PageInfo(list);
         * 4、Dao编写查询接口及注解
         * 5、查询总页数--查询总条数--计算
         * 6、把数据发送到页面
         */
        List<Dept> deptList = deptService.queryAllByPage(pageNum,pageSize,name);
        model.addAttribute("deptList",deptList);
        Map<String, Integer> countMap = deptService.queryTotalPage(pageSize,name);
        model.addAttribute("countMap",countMap);
        model.addAttribute("pageNum",pageNum);
        return "dept/deptList";
    }

    @GetMapping("insertPage")
    public String insertPage(){
        return "dept/deptInsert";
    }


    @PostMapping("insert")
    public String insert(Dept dept,Model model){
        deptService.insert(dept);
        if (dept.getId()>0){
            return "redirect:deptList?pageNum=1";
        } else {
            model.addAttribute("errorMsg","添加失败！！");
            model.addAttribute("dept",dept);
            return "dept/deptInsert";
        }
    }

    @PostMapping("delete")
    public String delete(int[] ids){
        deptService.delete(ids);
        return "redirect:deptList?pageNum=1";
    }

    @GetMapping("queryById")
    public String queryById(int ids,Model model){
        Dept dept = deptService.queryById(ids);
        model.addAttribute("dept",dept);
        return "dept/deptUpdate";
    }

    @PostMapping("update")
    public String update(Dept dept,Model model){
        int count = deptService.update(dept);
        //count = 0;
        if (count>0){
            //修改成功
            return "redirect:deptList?pageNum=1";
        } else {
            //修改失败
            model.addAttribute("errorMsg","修改失败！！");
            //Dept dept2 = deptService.queryById(dept.getId());
            model.addAttribute("dept",dept);
            return "dept/deptUpdate";
        }
    }

}
