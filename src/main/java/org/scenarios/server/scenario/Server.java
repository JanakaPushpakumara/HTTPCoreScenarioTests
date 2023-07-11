package org.scenarios.server.scenario;

public interface Server
{

    /**
     * Use to start the Server
     * @param port
     * @param content
     * @throws Exception
     */
    void start(int port, String content) throws Exception;

    /**
     * Used to stop the Server
     * @throws InterruptedException
     */
    void stop() throws InterruptedException;
}
