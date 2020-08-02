package com.tonyvonwolfe.terra.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "server_instance")
public class ServerInstance {
    @Id
    @GeneratedValue
    private Long id;


    @NonNull
    private String name; // name of the server.
    @NonNull
    private String serverPath; // points to the folder the server executes out of.
    private boolean isRunning; // indicates whether the server is online or not.

    private Timestamp lastServerStartTimestamp; // timestamp of the last time the server was started.

}
