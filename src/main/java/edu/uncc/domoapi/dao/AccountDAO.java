package edu.uncc.domoapi.dao;

import edu.uncc.domoapi.entity.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Transactional
@Repository
public class AccountDAO implements IAccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // method to save acc
    @Override
    public Account registerAccount(Account account){
        if (!accountExists(account.getAccNum())){
            entityManager.persist(account);
            entityManager.flush();
            return account;
        }
        return null;
    }
    // method to get acc by acc no
    @Override
    public Account getAccountByAccNo(String accNum){
        Logger.getAnonymousLogger().info("Acc Num"+accNum);
       if (accountExists(accNum)){
           String jpql = "select acc from Account as acc WHERE acc.accNum = ?1";
           return (Account) entityManager.createQuery(jpql).setParameter(1,accNum).getResultList().get(0);
       }
       return null;
    }
    // method to get all accs
    @Override
    public List<Account> getAllAccounts(){
        List<Account> accountList = (List<Account>) entityManager.createNamedQuery("Account.getAll").getResultList();
        Logger.getAnonymousLogger().info(accountList.toString());
        return accountList;
    }

    @Override
    public List<Account> getAccountStream(){
        return (List<Account>) entityManager.createNamedQuery("Account.getAll").getResultStream().collect(Collectors.toList());
    }
    // method to check if acc exists.
    private boolean accountExists(String accNo){
        String jpql = "select acc from Account as acc WHERE acc.accNum = ?1";
        int count = entityManager.createQuery(jpql).setParameter(1, accNo).getResultList().size();
        return count > 0;
    }
}
