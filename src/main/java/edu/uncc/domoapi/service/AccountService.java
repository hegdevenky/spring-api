package edu.uncc.domoapi.service;

import edu.uncc.domoapi.dao.IAccountDAO;
import edu.uncc.domoapi.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService implements IAccountService {

    @Autowired
    IAccountDAO accountDAO;

    @Override
    public Account registerAccount(Account account){
        LocalDate localDate =  LocalDate.now();
        account.setDateCreated(localDate);
        return accountDAO.registerAccount(account);
    }


    @Override
    public Account getAccountByAccNo(String accNum){
        return accountDAO.getAccountByAccNo(accNum);
    }

    @Override
    public List<Account> getAllAccounts(){
        List<Account> accountList = accountDAO.getAllAccounts();
        Logger.getAnonymousLogger().info(accountList.toString());
        return accountList;
    }
}
