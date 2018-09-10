/**
 * 
 */
package com.turkmen.objects;



/**
* <h1>The message object where all communicaton info are carried on./h1>
* 
* It is a kind of custom LinkedList where the messages
* in a message thread are kept and linked to each other. When a new message comes in ,it is added to the tail of this linkedlist
* 
*
* @author  Turkmen
* @see Message
* @version 1.0
* @since   2018-09-09
* 
* 
*/
public class Message
{

    /**
     * The message text where the recipients write the message
     */
    private String text;

    
    /**
     * The player who is sending the message
     */
    private Player from;

    /**
     * The player who is getting the message
     */
    private Player to;
    
    /**
     * The place where the replies of the first messages are kept recursively.
     */
    private Message replyToThis;
    
    /**
     * The id implying where this message and all messages in linked list are belong to.
     */
    private String threadId;
    

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Player getFrom()
    {
        return from;
    }

    public void setFrom(Player from)
    {
        this.from = from;
    }

    public Player getTo()
    {
        return to;
    }

    public void setTo(Player to)
    {
        this.to = to;
    }

    public void setNextMessage(Message nextMessage)
    {
        this.replyToThis = nextMessage;
    }

    public Message getNextMessage()
    {
        return replyToThis;
    }

    public String getThreadId()
    {
        return threadId;
    }

    public void setThreadId(String threadId)
    {
        this.threadId = threadId;
    }

   
    
    
    
}
