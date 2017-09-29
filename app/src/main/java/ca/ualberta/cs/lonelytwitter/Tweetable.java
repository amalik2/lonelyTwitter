/**
 * Tweetable
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
 * Represents a tweetable object that contains a message and a date
 *
 * @author Adil Malik
 * @version 1.0
 * @see ca.ualberta.cs.lonelytwitter.NormalTweet
 * @see ca.ualberta.cs.lonelytwitter.ImportantTweet
 * @since 1.0
 */

public interface Tweetable {
    /**
     * @return the message of this tweetable
     */
    String getMessage();

    /**
     * @return the date of this tweetable
     */
    Date getDate();
}
