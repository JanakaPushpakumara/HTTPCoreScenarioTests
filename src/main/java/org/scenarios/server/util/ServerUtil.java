package org.scenarios.server.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This call is a util class for Server
 */
public class ServerUtil
{

    private static final ServerUtil INSTANCE = new ServerUtil();

    private ServerUtil(){
        // Cannot create any objects
    }

    public static ServerUtil getInstance() {
        return INSTANCE;
    }


    /**
     * Use to read files from a given location
     * @param fileLocation file location
     * @return content of the file in String
     * @throws IOException if an exception occored
     */
    public String readFile(String fileLocation) throws IOException
    {
        try(BufferedReader br = new BufferedReader(new FileReader(fileLocation)))
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

}
