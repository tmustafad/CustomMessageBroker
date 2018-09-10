package com.turkmen;

import java.util.Scanner;

import com.turkmen.engine.MessageBroker;
import com.turkmen.engine.MessageBrokerImpl;
import com.turkmen.objects.Message;
import com.turkmen.objects.Player;
import com.turkmen.objects.PlayerImpl;

/**
* <h1>The starting point of this messaging application</h1>
* In main method of this class a scanner is created together with a
* MessageBroker and two players.  The Message object is populated with
* a text coming from user who is running this program.
* 
* The program expects the initiator to send a message to receiver ,
* then the receiver automatically sends back a response to initiator.
* Once the message thread limit is reached,the program exits the process 
* silently with exit code 0 .
*
* @author  Turkmen
* @version 1.0
* @since   2018-09-09
*/
public class StartApplication
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        MessageBroker messageBroker = new MessageBrokerImpl();

        Player player1 = new PlayerImpl(messageBroker, "Tom_initiator");
        Player player2 = new PlayerImpl(messageBroker, "John_receiver");

        System.out.println("Initiator : " + player1.getName());
        System.out.println("Receiver : " + player2.getName());
        System.out.println("---------------------------------");

        Message message = null;
        String messageThreadId = null;

        while (message == null)
        {
            System.out.println("Write down a  message for John : ");
            message = new Message();
            message.setFrom(player1);
            message.setTo(player2);
            message.setText(scanner.nextLine());
            if (messageThreadId != null)
                message.setThreadId(messageThreadId);

            player1.send(message);
            messageThreadId = message.getThreadId();
            message = null;
        }

    }
}
