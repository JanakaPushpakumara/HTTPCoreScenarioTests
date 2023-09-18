package org.scenarios.server.scenario;

import org.scenarios.server.util.ServerUtil;

import static org.scenarios.server.conf.ServerConfiguration.BACKEND_SERVER_PORT;
import static org.scenarios.server.conf.ServerConfiguration.JSON_FILE_PATH_1MB;

public class ServerMain {



    public static void main(String[] args) throws Exception {
        System.out.println("Starting the Test Server main!");

        String content = ServerUtil.getInstance().readFile(JSON_FILE_PATH_1MB);

        // This class contains main methods to run the back end servers separately

        ////////////// Backend server list SSLServerSendImediatexxx /////////////

        SSLServerSendImmediate503 sslServerSendImmediate503 = new SSLServerSendImmediate503();
        sslServerSendImmediate503.start(BACKEND_SERVER_PORT, content);

        SSLServerSendImmediate200 sslServerSendImmediate200 = new SSLServerSendImmediate200();
        sslServerSendImmediate200.start(BACKEND_SERVER_PORT, content);

        SSLServerSendImmediate300 sslServerSendImmediate300 = new SSLServerSendImmediate300();
        sslServerSendImmediate300.start(BACKEND_SERVER_PORT, content);

        SSLServerSendImmediate400 sslServerSendImmediate400 = new SSLServerSendImmediate400();
        sslServerSendImmediate400.start(BACKEND_SERVER_PORT, content);

        ///////////// Backend server list SSLServerSendImediatexxxWithoutPayload /////////////

        SSLServerSendImmediate503WithoutPayload sslServerSendImmediate503WithoutPayload = new SSLServerSendImmediate503WithoutPayload();
        sslServerSendImmediate503WithoutPayload.start(BACKEND_SERVER_PORT, content);

        SSLServerSendImmediate200WithoutPayload sslServerSendImmediate200WithoutPayload = new SSLServerSendImmediate200WithoutPayload();
        sslServerSendImmediate200WithoutPayload.start(BACKEND_SERVER_PORT, content);

        SSLServerSendImmediate300WithoutPayload sslServerSendImmediate300WithoutPayload = new SSLServerSendImmediate300WithoutPayload();
        sslServerSendImmediate300WithoutPayload.start(BACKEND_SERVER_PORT, content);

        SSLServerSendImmediate400WithoutPayload sslServerSendImmediate400WithoutPayload = new SSLServerSendImmediate400WithoutPayload();
        sslServerSendImmediate400WithoutPayload.start(BACKEND_SERVER_PORT, content);

    }
}
