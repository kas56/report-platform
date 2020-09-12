package ru.plot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.plot.entity.Account;
import ru.plot.repo.AccountRepository;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public HttpEntity<?> getAccountsList() {
        List<Account> all = (List<Account>) accountRepository.findAll();
        return new HttpEntity<>(all);
    }
}
