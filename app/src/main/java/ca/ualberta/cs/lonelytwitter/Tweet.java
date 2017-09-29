/**
 * Tweet
 *
 * Version 1.0
 *
 * September 28, 2017
 *
 * Copyright (c) Team X, CMPUT301, University of Alberta - All Rights Reserved. You may use, distribute, or modify this code under terms and conditions of the Code of Students Behaviour at University of Alberta
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a Tweet
 *
 * @author Adil Malik
 * @version 1.0
 * @see ca.ualberta.cs.lonelytwitter.NormalTweet
 * @see ca.ualberta.cs.lonelytwitter.ImportantTweet
 * @since 1.0
 */

public abstract class Tweet {

    /** What message this tweet contains*/
    private String message;
    /** The date this tweet was created on*/
    private Date date;

    /**
     * Create a new tweet object
     * @param message tweet message (not null)
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Create a new tweet object
     * @param message tweet message (not null)
     * @param date tweet date (not null)
     */
    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    /**
     * @return whether this tweet is important or not
     */
    public abstract Boolean isImportant();

    /**
     * Change the message of this tweet
     * @param message new message of the tweet, and should not be null
     * @throws TweetTooLongException when the message length is larger than 140
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    /**
     * @return the message of the tweet
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * @return the tweet's date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the tweet's date
     * @param date tweet's new date, and should not be null
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return a string representation of this tweet
     */
    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
