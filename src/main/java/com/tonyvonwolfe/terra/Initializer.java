package com.tonyvonwolfe.terra;

import com.tonyvonwolfe.terra.model.*;
import org.apache.tomcat.jni.Time;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Collections;
import java.util.EventListener;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner{
    private final ServerInstanceRepository repository;

    public Initializer(ServerInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Main Server", "Server #2", "Spigot Server Uno").forEach(name -> {
            repository.save(new ServerInstance(name, "/home/tony/Documents/server.jar"));
        });

        ServerInstance mainServer = repository.findByName("Main Server");
        mainServer.setLastServerStartTimestamp(new Timestamp(Instant.now().toEpochMilli()));

        repository.save(mainServer);

        repository.findAll().forEach(System.out::println);
    }
}
