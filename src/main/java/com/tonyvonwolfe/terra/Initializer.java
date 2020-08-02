package com.tonyvonwolfe.terra;

import com.tonyvonwolfe.terra.model.ServerInstance;
import com.tonyvonwolfe.terra.model.ServerInstanceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {
    private final ServerInstanceRepository repository;

    public Initializer(ServerInstanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Main Server", "Secondary Server", "Snapshot Server"). forEach(name ->
                repository.save(new ServerInstance(name, "/home/tony/Documents/server.jar")));

        repository.findAll().forEach(System.out::println);
    }
}
