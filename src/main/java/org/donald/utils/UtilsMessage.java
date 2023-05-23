package org.donald.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class UtilsMessage {

    /**
     * Ask action for the user in the console
     * @param scanner
     * @return the id of the action
     */
    public static int askAction(Scanner scanner){
        System.out.println( "Please, which service is this terminal for ? \n");
        System.out.println( "1 - Server\n2 - Client\n0 - Exit the terminal");

        int action = scanner.nextInt(); //Read the next Integer from the User

        //Check of the action is valid
        while (action < 0 || action > 2) {
            System.out.println( action + " is not a valid choice !");
            System.out.println( "Please, which service is this terminal for ? \n");
            System.out.println(" 1 - Server\n2 - Client\n0 - Exit the terminal");
            action = scanner.nextInt();
        }

        return action;
    }


    /**
     * Ask port for the user in the console
     * @param scanner
     * @return the port number
     */
    public static int askPort (Scanner scanner){
        System.out.println( "Which port number do you want to use ? (0 to exit)");

        int port = scanner.nextInt(); //Read the next Integer from the User

        //Check of the port is valid
        while (port < 0 || 9999 < port) {
            System.out.println("The port number " + port + " is not accepted.");
            System.out.println("Please, select a valid number between 1-9999 !");
            port = scanner.nextInt();
        }

        return port;
    }

    /**
     * Remove the name of a message and put "YOU" (Just for the sender)
     * @param message
     * @return
     */
    public static String removeNameFromMessage(String message){
        String[] args = message.split(":");
        if (args.length == 0)
            return message;

        StringBuilder result = new StringBuilder("You:" );
        for(int i = 1; i < args.length; i++)
            result.append(args[i]);

        return result.toString();
    }

    /**
     * Remove the name of a message and put "YOU" (Just for the sender)
     * @param version
     */
    public static void welcomeMessage (String version){
        System.out.println(ConsoleColors.YELLOW + "###########################################################################"+ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN +"                   "+ConsoleColors.RESET+""+ConsoleColors.GREEN_UNDERLINED +"Application version : v"+version+""+ConsoleColors.RESET+"                     ");
        System.out.println(ConsoleColors.YELLOW +"###########################################################################\n\n"+ConsoleColors.RESET);
    }
    /**
     * Reversed a message (ABCD --> DCBA)
     * @param message : The message to need to be reversed
     * @return reversed message
     */
    public static String reverseMessage(String message) {
        if ((null == message) || (message.length() <= 1)) {
            return message;
        }
        return reverseMessage(message.substring(1)) + message.charAt(0);
    }
}
