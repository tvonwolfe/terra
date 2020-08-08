package com.tonyvonwolfe.terra.web;

import com.tonyvonwolfe.terra.model.ServerInstance;
import com.tonyvonwolfe.terra.model.ServerInstanceRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ServerInstanceController {

    private final String SERVERS_ROUTE = "/servers";
    private final String SERVER_ROUTE = "/server";

    private final Logger LOGGER = LoggerFactory.getLogger(ServerInstanceController.class);
    private final ServerInstanceRepository serverInstanceRepository;

    public ServerInstanceController(ServerInstanceRepository serverInstanceRepository) {
        this.serverInstanceRepository = serverInstanceRepository;
    }

    @GetMapping(SERVERS_ROUTE)
    Collection<ServerInstance> servers() {
        return serverInstanceRepository.findAll();
    }

    @GetMapping(SERVER_ROUTE + "/{id}")
    ResponseEntity<?> getServerInstance(@PathVariable Long id) {
        Optional<ServerInstance> serverInstance = serverInstanceRepository.findById(id);

        return serverInstance.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(SERVER_ROUTE)
    ResponseEntity<ServerInstance> createServer(@Valid @RequestBody ServerInstance serverInstance) throws URISyntaxException {
        LOGGER.info("Request to create server: {}", serverInstance);
        ServerInstance result = serverInstanceRepository.save(serverInstance);
        return ResponseEntity.created(new URI("/api" + SERVER_ROUTE + result.getId())).body(result);
    }

    @PutMapping(SERVER_ROUTE + "/{id}")
    ResponseEntity<ServerInstance> updateServer(@Valid @RequestBody ServerInstance serverInstance) {
        LOGGER.info("Request to update server: {}", serverInstance);
        ServerInstance result = serverInstanceRepository.save(serverInstance);

        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping(SERVER_ROUTE + "/{id}")
    ResponseEntity<?> deleteServer(@PathVariable Long id) {
        LOGGER.info("Request to delete server: {}", id);
        serverInstanceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(SERVER_ROUTE + "/{id}/start")
    ResponseEntity<?> startServer(@PathVariable Long id) {
        LOGGER.info("Request to start server: {}", id);
        Optional<ServerInstance> server = serverInstanceRepository.findById(id);

        return server.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
