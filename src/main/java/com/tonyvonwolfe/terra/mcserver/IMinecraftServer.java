package com.tonyvonwolfe.terra.mcserver;

import java.util.concurrent.CompletableFuture;

/**
 * High-level interface for managing a Minecraft Server. Provides methods for
 * basic server ops such as start/stop and checking whether the server is
 * running or not, as well as basic configurations such as jar file to use.
 */
public interface IMinecraftServer {

    /**
     * Starts a Minecraft server process. Does nothing and returns immediately if
     * the server is already running.
     *
     * @return true if the process started successfully, false otherwise.
     */
    CompletableFuture<Boolean> startServer();

    /**
     * Terminates a running Minecraft server process. Will exit a running process.
     * Returns immediately if the process has already stopped.
     * 
     * @return the exit code of the Minecraft server process.
     */
    CompletableFuture<Integer> stopServer();

    /**
     * Checks if the server process is currently executing.
     *
     * @return true if the server is running, false otherwise.
     */
    boolean isServerRunning();

    /**
     * Assigns a new file path to the Minecraft server jar file.
     * <p>
     * 
     * @param newJarFilePath the absolute filepath to the new jar file to use for
     *                       the Minecraft server. NOTE: If a server is already
     *                       running, changing the server jar file path will take
     *                       effect on the next server startup.
     */
    void assignServerJar(String newJarFilePath);

    /**
     * Retrieves the absolute path to the Minecraft server jar file being used for
     * this server.
     *
     * @return the absolute filepath to the server's jar file.
     */
    String getServerJarFilePath();

    /**
     * Gets the number of users currently connected to the Minecraft server.
     *
     * @return the number of players connected to the server.
     * @throws ServerStateException if the server is not running.
     */
    int getNumConnectedPlayers();

    /**
     * Gets the last server start time in milliseconds since Unix epoch.
     *
     * @return the timestamp of the last server start in milliseconds since Unix
     *         epoch.
     * @throws ServerStateException if the server has never been started before.
     */
    long getLastServerStartTime();

    /**
     * Determines the approximate average latency between the server and the client
     * accessing the server management console, in milliseconds.
     *
     * @return the approximate server latency for the user, in milliseconds.
     */
    CompletableFuture<Integer> determineLatencyMilliseconds();
}
