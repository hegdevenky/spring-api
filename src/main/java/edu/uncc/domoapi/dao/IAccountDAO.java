package edu.uncc.domoapi.dao;

import edu.uncc.domoapi.entity.Account;

import java.util.List;

public interface IAccountDAO {
    // method to save acc
    Account registerAccount(Account account);

    // method to get acc by id
    Account getAccountById(Integer id);

    // method to get acc by acc no
    Account getAccountByAccNo(String accNo);

    // method to get all accs
    List<Account> getAllAccounts();

    List<Account> getAccountStream();
}
