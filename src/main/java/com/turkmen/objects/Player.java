/**
 * 
 */
package com.turkmen.objects;

import com.turkmen.engine.MessageBroker;


/**
* <h1>The abstract player class where all players are extending to create new type of players</h1>
* 
*The blueprint of the concrete player class in this program.
* 
*
* @author  Turkmen
* @see PlayerImpl
* @version 1.0
* @since   2018-09-09
* 
* 
*/
public abstract class Player
{

    /**
     * The message broker which all players are being interacted to
     */
    protected MessageBroker messageBroker;

    
    /**
     * The name of this player
     */
    protected String name;


    /**
     * Constructs player with the given message broker and name. Note that ,there is only one message broker per process
     *
     * @param  messageBroker  the broker for keeping all messages
     * 
     * @param  name  the name of the player
     */
    public Player(MessageBroker messageBroker, String name)
    {
        super();
        this.messageBroker = messageBroker;
        this.name = name;

    }


    /**
     * defines the blueprint of sending message for each extending player class
     *
     * @param  message  the message to be passed to broker
     * 
     */
    public abstract void send(Message message);


    /**
     * defines the blueprint of receiving message for each extending player class
     *
     * @param  message  the message to be passed to broker
     * 
     */
    public abstract void receive(Message message);

 

    public String getName()
    {
        return name;
    }

}
