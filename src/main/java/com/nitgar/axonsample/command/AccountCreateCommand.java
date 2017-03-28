package com.nitgar.axonsample.command;

/**
 * Created by anuraggupta on 28/03/17.
 */
public class AccountCreateCommand {
    private final String accountNo;

    public AccountCreateCommand(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }
}
