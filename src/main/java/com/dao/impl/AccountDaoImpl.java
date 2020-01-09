package com.dao.impl;

import com.dao.AccountDao;
import com.pojo.AccountDO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

      private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }



    public void saveAccout(AccountDO accountDO) {
        try {
            runner.update("insert into account(name,money) values (?,?)",accountDO.getName(),accountDO.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AccountDO findAccountById(Integer id) {
        try {
            return runner.query("select * from account where id =?",new BeanHandler<AccountDO>(AccountDO.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("异常");
        }
    }

    public List<AccountDO> findAllAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<AccountDO>(AccountDO.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("异常");
        }
    }

    public void updateAccount(AccountDO accountDO) {
        try {
            runner.update("update account set name=?,money =? where id =?",accountDO.getName(),accountDO.getMoney(),accountDO.getId());
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deleteAccount(Integer id) {
        try {
            runner.update("delete from account  where id =?",id);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
