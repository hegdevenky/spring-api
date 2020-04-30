package edu.uncc.domoapi.api;

import com.sun.xml.bind.v2.TODO;
import edu.uncc.domoapi.entity.Account;
import edu.uncc.domoapi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dd-api")
public class AccountController {

    @Autowired
    IAccountService accountService;

    // register acc
    @PostMapping("/account")
    public EntityModel<Account> registerAccount(@RequestBody Account account){
        account = accountService.registerAccount(account);
//        if (account == null)
            return new EntityModel<>(account, linkTo(methodOn(AccountController.class).registerAccount(account)).withSelfRel());
    }
    // get account by account number
    @GetMapping("/account/{accNum}")
    public EntityModel<Account> getAccountByAccNum(@PathVariable("accNum") int accNum){
        Account account = accountService.getAccountByAccNo(String.valueOf(accNum));
        EntityModel<Account> response = new EntityModel<>(account, linkTo(methodOn(AccountController.class).getAccountByAccNum(accNum)).withSelfRel());
        return response;
    }

    // get account by id
    @GetMapping("/accounts/{id}")
    public EntityModel<Account> getAccountById(@PathVariable("id") int id){
        Account account = accountService.getAccountById(id);
        EntityModel<Account> response = new EntityModel<>(account, linkTo(methodOn(AccountController.class).getAccountById(id)).withSelfRel());
        return response;
    }

    //TODO: Fix this
    public EntityModel<List<Account>> getAllAccounts(){
        List<Account> accountList = accountService.getAllAccounts();
        Logger.getAnonymousLogger().info(accountList.toString());
        EntityModel<List<Account>> response = new EntityModel<>(accountList, linkTo(methodOn(AccountController.class).getAllAccounts()).withSelfRel());
        return response;
    }
    // get all accounts
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccountsRes(){
        List<Account> accountList = accountService.getAllAccounts();
        return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
    }
}

