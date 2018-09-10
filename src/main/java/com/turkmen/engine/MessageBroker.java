/**
 * 
 */
package com.turkmen.engine;

import java.util.Map;

import com.turkmen.objects.Message;
import com.turkmen.objects.MessageThread;

/**
* <h1>The messaging mediator interface for this applicaton</h1>
* 
* This interface and its implementers are  for providing a messaging
* structure for this application. All players send messages to each other
* through this interface and its implementers.
* 
*
* @author  Turkmen
* @see MessageBrokerImpl
* @version 1.0
* @since   2018-09-09
* 
* 
*/
public interface MessageBroker
{


    /**
     * Sends the given message to the recipient 
     *
     *@param message the message where the text,from,to and threadid is set
     */
    public void sendMessage(Message message);
    
    
    /**
     * creates a message thread consisting of messages between two players 
     *
     *@param message the message where the text,from,to and threadId is set.
     */
    public void createMessageThread(Message message);
    
    
    
    /**
     * adds the given message to the thread according to the threadId on the message
     *
     *@param message the message where the text,from,to and threadId is set.
     */
    public void addToMessageThread(Message  message);


    
    /**
     * the method to access the message threads on this message broker.
     * 
     */
    public Map<String, MessageThread> getMessageThreads();

}
