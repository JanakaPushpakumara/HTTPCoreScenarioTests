package org.scenarios.server.scenario;

import java.io.PrintWriter;

/**
 * Sample Server.
 * Server will send Immediate response with 400 Bad Request without a payload
 */
public class SSLServerSendImmediate400WithoutPayload extends AbstractSSLServer {

    @Override
    void writeToTheOut(PrintWriter out) {
        // If you need to add more things you can add here.
    }

    @Override
    String getName() {
        return "Immediate Response Without Message Body";
    }

    @Override
    String getStatusCode() {
        return "400 Bad Request";
    }

    public int getContentLength()
    {
        return 0;
    }
}
