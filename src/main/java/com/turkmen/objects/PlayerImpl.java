/**
 * 
 */
package com.turkmen.objects;

import com.turkmen.engine.MessageBroker;
import com.turkmen.util.Util;

/**
* <h1>The concrete player class where all functionality of a player is implemented</h1>
* 
*The blueprint of the concrete player class in this program.
* 
*
* @author  Turkmen
* @see Player
* @version 1.0
* @since   2018-09-09
* 
* 
*/
public class PlayerImpl extends Player
{

    
    /**
     * Constructs player with the given message broker and name. Note that ,there is only one message broker per process
     *
     * @param  messageBroker  the broker for keeping all messages
     * 
     * @param  name  the name of the player
     */
    public PlayerImpl(MessageBroker messageBroker, String name)
    {
        super(messageBroker, name);
    }


    
    
    /**
     * implements this method defined in extended abstract class.A call to message broker is made with the given message
     *
     * @param  message  the message to be passed to broker
     * 
     */
    @Override
    public void send(Message message)
    {
        System.out.println(this.name + " : sending message = " + message.getText());
        messageBroker.sendMessage(message);

    }


    
    /**
     *implements this method defined in extended abstract class.First the thread count is taken,
     *then it is checked if count exceeds 10 or not.If so, the process exits with the code 0. A reply is sent to initiator if the receiving
     *player is receiver. This is inspected by checking the modulus of the count.
     *
     * @param  message  the message to be passed to broker
     * 
     */
    @Override
    public void receive(Message message)
    {

        int threadCount = this.messageBroker.getMessageThreads().get(message.getThreadId()).getCount();
        System.out.println(this.name + " receiving message = " + message.getText() + " Sender :" + message.getFrom().getName());

        if (threadCount >= 10)
        {
            System.out.println("Message count in the current message thread has reached the limit,exiting process......");
           Util.exitProcess();
        }

        if (threadCount % 2 != 0)
        {
            Message msg = new Message();
            msg.setFrom(this);
            msg.setTo(message.getFrom());
            msg.setText(message.getText() + "_" + ++threadCount);
            msg.setThreadId(message.getThreadId());
            this.send(msg);// sending a response back to initiator until the thread count reaches the limit of 10
        }

    }

}
