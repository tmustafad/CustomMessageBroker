package com.turkmen;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.turkmen.engine.MessageBroker;
import com.turkmen.engine.MessageBrokerImpl;
import com.turkmen.objects.Message;
import com.turkmen.objects.Player;
import com.turkmen.objects.PlayerImpl;

/**
 * Unit test for simple StartApplication.
 */
public class CustomMessageBrokerTest

{
    Message message = null;
    Player player1 = null;
    Player player2 = null;
    MessageBroker messageBroker = null;


    @BeforeClass
    public static void initializeMessagingEngineAndPlayers()
    {

        System.out.println("Tests are being runned.....");

    }


    @Before
    public void createMessage()
    {

        messageBroker = new MessageBrokerImpl();
        player1 = new PlayerImpl(messageBroker, "Tom_initiator");
        player2 = new PlayerImpl(messageBroker, "John_receiver");
        message = new Message();
        message.setFrom(player1);
        message.setTo(player2);
        message.setText("Hi there!");

    }


    @Test
    public void testcheckMessageBrokerMessageThreadCount_zero()
    {
        assertEquals(0, messageBroker.getMessageThreads().size());
    }


    @Test
    public void testcheckMessageBrokerMessageThreadCount_one()
    {
        player1.send(message);
        assertEquals(1, messageBroker.getMessageThreads().size());
    }

}
