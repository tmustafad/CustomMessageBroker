/**
 * 
 */
package com.turkmen.objects;

import java.util.UUID;

/**
* <h1>The message thread where all messages between two players are kept</h1>
* 
* This class is the place where the messages sent between two players are kept based on a thread Id.
* 
*
* @author  Turkmen
* @see Message
* @version 1.0
* @since   2018-09-09
* 
* 
*/
public class MessageThread
{

    /**
     * The id of the thread which is generated randomly, this id is used in message thread map in message broker.
     */
    private String id;
    
    /**
     * The first message in the message thread,  all other messages in the thread are responses of this first message
     */
    Message firstMessage;
    
    
    /**
     * The message count in this thread, based on this count the system decides to exit or stay in the process.
     */
    private int count;


    
    /**
     * Constructs an MessageThread with an automatically generated Id.
     *
     */
    public MessageThread()
    {
        this.id = UUID.randomUUID().toString();
    }


    
    
    /**
     *Adds the given message to the current message thread. In order to do this,all messages are traversed in the 
     *thread and message is added to the tail of this thread
     *
     * @param message The message which is passed to the recipient
     */
    public void addMessageToThread(Message message)
    {
        if (firstMessage != null)
        {
            Message temp = firstMessage;
            while (temp.getNextMessage() != null)
            {
                temp = temp.getNextMessage();
            }

            temp.setNextMessage(message);
            count++;
        }
        else
        {
            firstMessage = message;
            count++;
        }

    }


    public String getId()
    {
        return id;
    }


    public int getCount()
    {
        return count;
    }
    
    

}
