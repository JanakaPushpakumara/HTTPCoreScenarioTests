package org.scenarios.server;

import java.io.IOException;
import java.net.ServerSocket;

public class BackendServer {

    public static String ServerkeyStoreLocation = "/home/vikum/Desktop/ei-ticket/BNY/BNYTEST/wso2am-3.2.0-65s/wso2am-3.2.0/repository/resources/security/wso2carbon.jks";
    public static String ServerkeyStorePassword = "wso2carbon";
    protected ServerSocket ss;
    public static final String CRLF = "\r\n";
    public BackendServer() {
    }

    public void run(int port, String content) throws Exception {}

    public void shutdownServer() {
        try {
            System.out.println("Shutting down the server");
            ss.close();
        } catch (IOException ignore) {
            //
        }
    }
}