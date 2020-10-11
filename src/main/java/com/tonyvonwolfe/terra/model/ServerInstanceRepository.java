package com.tonyvonwolfe.terra.model;

import com.tonyvonwolfe.terra.model.mcserver.MCServer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerInstanceRepository extends JpaRepository<MCServer, Long> {
    MCServer findByName(String name);
}
