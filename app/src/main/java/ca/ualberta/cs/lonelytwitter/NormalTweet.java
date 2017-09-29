/**
 * NormalTweet
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
 * Represents a normal Tweet
 *
 * @author Adil Malik
 * @version 1.0
 * @see ca.ualberta.cs.lonelytwitter.Tweet
 * @see ca.ualberta.cs.lonelytwitter.Tweetable
 * @since 1.0
 */

public class NormalTweet extends Tweet {

    /**
     * Create a new NormalTweet object
     * @param message tweet message (not null)
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Create a new NormalTweet object
     * @param message tweet message (not null)
     * @param date tweet date (not null)
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * @return whether this tweet is important or not
     */
    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }

}
