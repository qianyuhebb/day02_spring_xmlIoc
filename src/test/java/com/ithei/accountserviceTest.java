package com.ithei;

import com.pojo.AccountDO;
import com.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//使用junit 测试
public class accountserviceTest {



    @Test
    public void testFindAll() {


        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService",AccountService.class);
        List<AccountDO> allAccount = accountService.findAllAccount();
        for (AccountDO accountDO : allAccount) {
            System.out.println(accountDO);

        }

    }
    @Test
    public void testFindOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService",AccountService.class);
       AccountDO allAccount = accountService.findAccountById(1);

            System.out.println(allAccount);


    }
    @Test
    public void testUpdate() {
        AccountDO accountDO = new AccountDO();
        accountDO.setName("测试");
        accountDO.setMoney("3333");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService",AccountService.class);

         accountService.saveAccout(accountDO);




    }
    @Test
    public void testDelete() {

    }
}
