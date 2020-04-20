package com.galaxy.web.controller;

import com.galaxy.entity.Account;
import com.galaxy.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountService accountService;


    @GetMapping("loginPage")
    public String loginPage() {
        // /WEB-INF/pages/+ account/login +.jsp
        return "account/login";
    }

    @GetMapping("list")
    public String list() {
        return "account/list";
    }

    @PostMapping("login")
    public String login(Account account, HttpSession session, Model model) {
        Account loginAccount = accountService.login(account);
        if (loginAccount == null) {
            model.addAttribute("errorMsg","用户名或密码错误");
            return "forward:/WEB-INF/pages/account/login.jsp";
        } else {
            session.setAttribute("loginAccount",loginAccount);
            //跳转到部门的列表显示页面
            return "redirect:/dept/deptList?pageNum=1";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginPage";
        //return "account/login";
    }



}
