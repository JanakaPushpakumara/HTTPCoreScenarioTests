package org.scenarios.server.scenario;

import java.io.PrintWriter;

/**
 * Sample Server.
 * Server will send Immediate response with 400 Bad Request with a payload
 */
public class SSLServerSendImmediate400 extends AbstractSSLServer {

    @Override
    void writeToTheOut(PrintWriter out) {
        // If you need to add more things you can add here.
    }

    @Override
    String getName() {
        return "Immediate Response";
    }

    @Override
    String getStatusCode() {
        return "400 Bad Request";
    }
}
