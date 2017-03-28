package com.nitgar.axonsample.event.handler;

import com.nitgar.axonsample.domain.Account;
import com.nitgar.axonsample.event.AccountCreateEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by anuraggupta on 28/03/17.
 */
@Component
public class AccountCreateEventHandler {
    @Autowired
    private Repository<Account> repository;
    @EventHandler
    public void handle(AccountCreateEvent event) {
        System.out.println("account create event happened..");
    }
}
