package com.tonyvonwolfe.terra.mcserver;

import java.util.concurrent.CompletableFuture;

public interface IMinecraftServer {

    CompletableFuture<Boolean> startServer();
    void stopServer();

    boolean isServerRunning();

    void assignServerJar(String newJarFilePath);
    String getServerJarFilePath();

    int getNumConnectedPlayers();

    long getLastServerStartTime();

    CompletableFuture<Integer> determineLatencyMilliseconds();
}
