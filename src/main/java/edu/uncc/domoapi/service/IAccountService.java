package edu.uncc.domoapi.service;

import edu.uncc.domoapi.entity.Account;

import java.util.List;

public interface IAccountService {
    Account registerAccount(Account account);

    Account getAccountById(Integer id);

    Account getAccountByAccNo(String accNum);

    List<Account> getAllAccounts();
}
