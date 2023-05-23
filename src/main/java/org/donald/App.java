package org.donald;

import org.donald.services.Server;
import org.donald.services.Client;
import org.donald.utils.UtilsMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Properties vProp = new Properties(); // Version properties
        InputStream vInputStream = null;
        try {
            vInputStream = App.class.getResourceAsStream("/info.properties");
            vProp.load(vInputStream);
        } finally {
            if (vInputStream != null)
                vInputStream.close();
        }
        String version = vProp.getProperty("org.donald.version", "?");
        System.out.println("Application version : " + version);
        System.out.println("****************************************************\n");

        UtilsMessage.welcomeMessage(version);

        // Create Scanner to read entries
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        int action = UtilsMessage.askAction(scanner); // Get action of the user

        if (action == Action.SHUTDOWN.getAction()) // Shutdown if action == shutdown
            return;

        int port = UtilsMessage.askPort(scanner); // Get port number

        if (port == Action.SHUTDOWN.getAction()) // Shutdown if action == shutdown
            return;

        // Creation of the service !
        System.out.println("Creation of the service...\n");
        System.out.println("****************************************************\n");

        if (action == Action.CREATE_SERVER.getAction())
            createServer(port);
        else if (action == Action.CREATE_CLIENT.getAction())
            createClient(port);
    }

    /**
     * Create a server on the specified port
     * 
     * @param port
     * @throws IOException
     */
    private static void createServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket((port));
        Server server = new Server(serverSocket);
        server.startServer();
    }

    /**
     * Create a client on the specified port
     * 
     * @param port
     * @throws IOException
     */
    private static void createClient(int port) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for the group chat: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", port);
        Client client = new Client(socket, username);
        client.listenForMessage();
        client.sendMessage();
        scanner.close();
    }

    /**
     * Enumeration of possible actions of the application
     */
    enum Action {

        SHUTDOWN(0),
        CREATE_SERVER(1),
        CREATE_CLIENT(2);

        private final int action;

        Action(int action) {
            this.action = action;
        }

        public int getAction() {
            return action;
        }
    }
}
