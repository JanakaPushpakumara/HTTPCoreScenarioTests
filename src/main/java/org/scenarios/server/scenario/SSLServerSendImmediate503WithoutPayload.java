package org.scenarios.server.scenario;

import java.io.PrintWriter;

/**
 * Sample Server.
 * Server will send Immediate response with 503 Service Unavailable without a payload
 */
public class SSLServerSendImmediate503WithoutPayload extends AbstractSSLServer {

    @Override
    void writeToTheOut(PrintWriter out)
    {
        // If you need to add more things you can add here.
    }

    @Override
    String getName() {
        return "Immediate Response Without Message Body";
    }

    @Override
    String getStatusCode() {
        return "503 Service Unavailable";
    }
}
