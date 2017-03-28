package com.nitgar.axonsample.configuration;

import com.nitgar.axonsample.domain.Account;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerBeanPostProcessor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventhandling.annotation.AnnotationEventListenerBeanPostProcessor;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;
import org.axonframework.repository.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * Created by anuraggupta on 27/03/17.
 */
@Configuration
@AnnotationDriven
public class AppConfiguration {
    @Bean
    public CommandBus commandBus() {
        return new SimpleCommandBus();
    }

    @Bean
    public EventBus eventBus() {
        return new SimpleEventBus();
    }

    @Bean
    public CommandGateway commandGateway() {
        return new DefaultCommandGateway(commandBus());
    }

    @Bean
    public EventStore eventStore() {
        EventStore eventStore =
                new FileSystemEventStore(new SimpleEventFileResolver(new File("./events")));
        return eventStore;
    }

    @Bean
    public Repository<Account> eventSourcingRepository() {
        EventSourcingRepository eventSourcingRepository =
                new EventSourcingRepository(Account.class, eventStore());
        eventSourcingRepository.setEventBus(eventBus());
        return eventSourcingRepository;
    }
}
