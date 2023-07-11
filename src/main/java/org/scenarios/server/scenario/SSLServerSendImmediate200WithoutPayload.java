package org.scenarios.server.scenario;

import java.io.PrintWriter;

/**
 * Sample Server.
 * Server will send Immediate response with 200 OK without a payload
 */
public class SSLServerSendImmediate200WithoutPayload extends AbstractSSLServer {

    @Override
    void writeToTheOut(PrintWriter out)
    {
        // If you need to add more things you can add here.
    }

    @Override
    String getName() {
        return "Immediate Response Without MessageBody";
    }

    @Override
    String getStatusCode() {
        return "200 OK";
    }

    public int getContentLength()
    {
        return 0;
    }

}
