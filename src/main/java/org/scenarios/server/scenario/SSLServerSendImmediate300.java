package org.scenarios.server.scenario;

import java.io.PrintWriter;

/**
 * Sample Server.
 * Server will send Immediate response with 300 Multiple Choices with a payload
 */
public class SSLServerSendImmediate300 extends AbstractSSLServer
{

    @Override
    void writeToTheOut(PrintWriter out)
    {
        out.print("Location: http://example.com/alternate-resource");
    }

    @Override
    String getName() {
        return "Immediate Response";
    }

    @Override
    String getStatusCode() {
        return "300 Multiple Choices";
    }
}
