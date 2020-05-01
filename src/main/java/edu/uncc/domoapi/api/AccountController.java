package edu.uncc.domoapi.api;

import com.sun.xml.bind.v2.TODO;
import edu.uncc.domoapi.entity.Account;
import edu.uncc.domoapi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
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
            return new EntityModel<>(account, linkTo(methodOn(AccountController.class).getAccountByAccNum(account.getAccNum())).withSelfRel());
    }

    @GetMapping(value = "/account", produces = {"application/json"})
    public EntityModel<Account> getAccountByAccNum(@RequestParam(required = true) final String accNum){
        Logger.getAnonymousLogger().info("Acc Num"+accNum);
        Account account = accountService.getAccountByAccNo(accNum);
        Link selfLink = linkTo(methodOn(AccountController.class).getAccountByAccNum(accNum)).withSelfRel();
        account.add(selfLink);
        return new EntityModel<Account>(account);
    }

    // get all accounts
    @GetMapping("/accounts")
    public CollectionModel<Account> getAllAccountsRes(){
        List<Account> accountList = accountService.getAllAccounts();
        for (Account account: accountList){
            Link selfLink = linkTo(methodOn(AccountController.class).getAccountByAccNum(account.getAccNum())).withSelfRel();
            account.add(selfLink);
        }
        Link link = linkTo(AccountController.class).withSelfRel();
        return new CollectionModel<>(accountList, link);
    }
}

