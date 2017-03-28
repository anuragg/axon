package com.nitgar.axonsample.event;

/**
 * Created by anuraggupta on 28/03/17.
 */
public class AccountCreateEvent {
    private final String accountNo;

    public AccountCreateEvent(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }
}
