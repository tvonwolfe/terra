package com.tonyvonwolfe.terra.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServerInstanceRepository extends JpaRepository<ServerInstance, Long> {
    ServerInstance findByName(String name);
}
