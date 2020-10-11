package com.tonyvonwolfe.terra;

import com.tonyvonwolfe.terra.model.*;
import com.tonyvonwolfe.terra.model.mcserver.MCServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
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
            repository.save(new MCServer(name, "/home/tony/Documents/server.jar"));
        });

        MCServer mainServer = repository.findByName("Main Server");
        mainServer.setLastServerStartTimestamp(new Timestamp(Instant.now().toEpochMilli()));

        repository.save(mainServer);

        repository.findAll().forEach(System.out::println);
    }
}
