package com.galaxy.service.impl;

import com.galaxy.dao.AccountDao;
import com.galaxy.entity.Account;
import com.galaxy.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public Account login(Account account) {
        return accountDao.login(account);
    }
}
