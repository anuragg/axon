package com.nitgar.axonsample.controller;

import com.nitgar.axonsample.command.AccountCreateCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by anuraggupta on 27/03/17.
 */
@RestController
public class HelloController {
    @Autowired
    private CommandGateway gateway;
    @RequestMapping("/hello")
    public String sayHello() {
        gateway.send(new AccountCreateCommand(UUID.randomUUID().toString()));
        return "Hello World!!";
    }
}
