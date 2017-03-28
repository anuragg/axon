package com.nitgar.axonsample.command.handler;

import com.nitgar.axonsample.command.AccountCreateCommand;
import com.nitgar.axonsample.domain.Account;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by anuraggupta on 28/03/17.
 */
@Component
public class AccountCreateCommandHandler {
    @Autowired
    private Repository<Account> repository;

    @CommandHandler
    public void handle(AccountCreateCommand command) {
        System.out.println("new account created command");
        repository.add(new Account(command.getAccountNo()));
    }
}
