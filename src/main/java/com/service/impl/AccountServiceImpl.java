package com.service.impl;

import com.dao.AccountDao;
import com.factory.BeanFactory;
import com.pojo.AccountDO;
import com.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

//    accountDaoImpl accountDao = new accountDaoImpl();
      /* int i =1;*/

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccout(AccountDO accountDO) {
        accountDao.saveAccout(accountDO);
    }



    public AccountDO findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public List<AccountDO> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public void updateAccount(AccountDO accountDO) {
         accountDao.updateAccount(accountDO);
    }

    public void deleteAccount(Integer id) {
               accountDao.deleteAccount(id);
    }
}
