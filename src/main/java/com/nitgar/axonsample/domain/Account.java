package com.nitgar.axonsample.domain;

import com.nitgar.axonsample.event.AccountCreateEvent;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

/**
 * Created by anuraggupta on 28/03/17.
 */
public class Account extends AbstractAnnotatedAggregateRoot<String> {

    @AggregateIdentifier
    private String accountNo;

    public Account() {

    }

    public Account(String accountNo) {
        apply(new AccountCreateEvent(accountNo));
    }

    @Override
    public String getIdentifier() {
        return accountNo;
    }

    @EventSourcingHandler
    public void handle(AccountCreateEvent event) {
        this.accountNo = event.getAccountNo();
        System.out.println("account create event sourcing!!" + event.getAccountNo());
    }
}
