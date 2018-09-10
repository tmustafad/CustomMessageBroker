/**
 * 
 */
package com.turkmen.engine;

import java.util.HashMap;
import java.util.Map;

import com.turkmen.objects.Message;
import com.turkmen.objects.MessageThread;


/**
* <h1>The messaging mediator interface implementer for this applicaton</h1>
* 
* This concrete class has one default constructor where the message thread map is initialized.
* It also provide the implementations of sendMessage,createMessageThread,addMEssageToThread
* methods
* 
*
* @author  Turkmen
* @see MessageBrokerImpl
* @version 1.0
* @since   2018-09-09
* 
* 
*/
public class MessageBrokerImpl implements MessageBroker
{

    
    /**
     * The thread map where all messages threads are kept.The keys of each map is
     * their id value which is generated randomly by UUID.
     */
    private Map<String, MessageThread> messageThreads;


    /**
     * Constructs an MessageBroker with an empty messagethread map
     *
     */
    public MessageBrokerImpl()
    {
        this.messageThreads = new HashMap<String, MessageThread>();
    }


    
    /**
     * In this method a message thread check is made,based on the result of this check
     * a new thread is created or message is added to the thread which already exists.
     *
     * @param message The message which is passed to the recipient
     */
    public void sendMessage(Message message)
    {
        if (message.getThreadId() == null)
        {
            this.createMessageThread(message);
            message.getTo().receive(message);
        }
        else
        {
            this.addToMessageThread(message);
            message.getTo().receive(message);
        }

    }


    /**
     *In this method ,a new messageThread is created and the message is added to that thread
     *then this message thread is put to the messagebroker messagethread map.
     *
     * @param message The message which is passed to the recipient
     */
    public void createMessageThread(Message message)
    {
        MessageThread messageThread = new MessageThread();
        messageThread.addMessageToThread(message);
        this.messageThreads.put(messageThread.getId(), messageThread);

        message.setThreadId(messageThread.getId());

    }


    /**
     *In this method message is added to already living message thread based on the threadId in the message itself.
     *
     * @param message The message which is passed to the recipient
     */
    public void addToMessageThread(Message message)
    {
        MessageThread thread=this.messageThreads.get(message.getThreadId());
        thread.addMessageToThread(message);
    }


    public Map<String, MessageThread> getMessageThreads()
    {
        return this.messageThreads;
    }


    public void setMessageThreads(Map<String, MessageThread> messageThreads)
    {
        this.messageThreads = messageThreads;
    }

}
