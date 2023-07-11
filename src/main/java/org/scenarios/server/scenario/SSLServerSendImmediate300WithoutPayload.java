package org.scenarios.server.scenario;

import java.io.PrintWriter;

/**
 * Sample Server.
 * Server will send Immediate response with 300 Multiple Choices without a payload
 */
public class SSLServerSendImmediate300WithoutPayload extends AbstractSSLServer {

    @Override
    void writeToTheOut(PrintWriter out)
    {
        out.print("Location: http://example.com/alternate-resource");
    }

    @Override
    String getName() {
        return "Immediate Response Without Message Body";
    }

    @Override
    String getStatusCode() {
        return "300 Multiple Choices";
    }

    public int getContentLength()
    {
        return 0;
    }
}
