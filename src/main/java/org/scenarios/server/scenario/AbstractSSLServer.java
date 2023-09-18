package org.scenarios.server.scenario;

import org.scenarios.server.conf.ServerConfiguration;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AbstractSSLServer implements Server{

    protected ServerSocket serverSocket;

    public AbstractSSLServer()
    {
        System.out.println("Initiating "+ this.getClass().getSimpleName() +" Server ");
    }
    public boolean isServerDone = true;
    public int contentLength = 0;

    public void start(int port, String content) throws Exception
    {
        System.setProperty("javax.net.ssl.keyStore", ServerConfiguration.SERVER_KEY_STORE_LOCATION);
        System.setProperty("javax.net.ssl.keyStorePassword", ServerConfiguration.SERVER_KEY_STORE_PASSWORD);
        ServerSocketFactory ssf = SSLServerSocketFactory.getDefault();
        serverSocket = ssf.createServerSocket(port);
        System.out.println("SSL Server Started!");

        do {
            Socket client = serverSocket.accept();
            System.out.println("Accepting the client connection ...");
            PrintWriter out = new PrintWriter(client.getOutputStream());
            contentLength = content.getBytes().length;

            System.out.println(" Sending "+ getName() +" without reading the request ( size:"+ getContentLength() +")");

            out.print("HTTP/1.1 " + getStatusCode() + "\r\n");
            out.print("Access-Control-Expose-Headers:\r\n");
            out.print("Access-Control-Allow-Origin: *\r\n");
            out.print("X-Correlation-ID: " + ServerConfiguration.CORRELATION_ID +"\r\n");
            out.print(
                    "Access-Control-Allow-Headers: authorization,Access-Control-Allow-Origin,Content-Type," +
                            "SOAPAction,apikey,testKey,Authorization\r\n");
            out.print("Content-Length:  " + getContentLength() + "\r\n");
            out.print("Content-Type: application/json\r\n");
            out.print("Date: Tue, 14 Dec 2021 08:15:17 GMT\r\n");


            writeToTheOut(out);

            out.print("Connection: Close\r\n");
            out.print("\r\n");
            out.print(content + "\r\n");
            out.flush();
            System.out.println(" Closing server connection ....");
            out.close();
            client.close();
        } while (true);

    }

    /**
     * Use this method to add more details to the out stream
     * @param out content that you need to append to
     */
    abstract void writeToTheOut(PrintWriter out);

    /**
     * Use to get the name of the test class
     * @return class name
     */
    abstract String getName();

    /**
     * Status code of the particular test
     * @return Status Code ex: 200, 404
     */
    abstract String getStatusCode();

    /**
     * Use this to get the content-length of the request
     * @return content length
     */
    public int getContentLength()
    {
        return contentLength;
    }

    /**
     * Use this to stop the running server
     * @throws InterruptedException when having a problem stoping the server
     */
    @Override
    public void stop() throws InterruptedException
    {
        try {
            while (!isServerDone){
                Thread.sleep(10);
            }
            System.out.println("Shutting down the  " + this.getClass().getSimpleName() + " Server");
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error while shutting down the " + this.getClass().getSimpleName() +" server ");
        }
    }
}