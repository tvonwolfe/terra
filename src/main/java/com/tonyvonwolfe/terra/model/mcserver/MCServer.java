package com.tonyvonwolfe.terra.model.mcserver;

import lombok.*;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.concurrent.CompletableFuture;
import java.io.File;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "server_instance")
public class MCServer implements IMinecraftServer {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name; // name of the server.

    @NonNull
    private String serverPath; // points to the folder the server executes out of.

    @ReadOnlyProperty
    private boolean isRunning; // indicates whether the server is online or not.

    @ReadOnlyProperty
    private Timestamp lastServerStartTimestamp; // timestamp of the last time the server was started.

    @Override
    public CompletableFuture<Boolean> startServer() {
        return null;
    }

    @Override
    public CompletableFuture<Integer> stopServer() {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> restartServer() throws ServerStateException {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> isServerRunning() {
        return null;
    }

    @Override
    public ServerPathAssignmentResult assignServerJar(String newJarFilePath) {
        final File jarFile = new File(newJarFilePath);

        final ServerPathAssignmentResult result = !jarFile.exists() ? 
            ServerPathAssignmentResult.INVALID_FILE_PATH : 
            !jarFile.isFile() ? ServerPathAssignmentResult.NOT_A_FILE :
            ;

        return result;
    }

    @Override
    public String getServerJarFilePath() {
        return this.serverPath;
    }

    @Override
    public CompletableFuture<Integer> getNumConnectedPlayers() throws ServerStateException {
        return null;
    }

    @Override
    public long getLastServerStartTime() throws ServerStateException {
        return this.lastServerStartTimestamp.getTime();
    }

    @Override
    public CompletableFuture<Integer> getMeasuredLatency() throws ServerStateException {
        return null;
    }
}
