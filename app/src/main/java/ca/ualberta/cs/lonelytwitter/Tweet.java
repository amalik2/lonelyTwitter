package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by malik2 on 9/14/17.
 */

public abstract class Tweet implements Tweetable{

    private static final int MAX_TWEET_LENGTH = 140;

    private String message;
    private Date date;
    private List<MoodBase> moods;

    public Tweet(String tweetMessage){
        this.message = tweetMessage;
        this.date = new Date();
        moods = new ArrayList<MoodBase>();
    }

    public Tweet(String tweetMessage, Date tweetDate){
        this.message = tweetMessage;
        this.date = tweetDate;
        moods = new ArrayList<MoodBase>();
    }

    public Tweet(String tweetMessage, Date tweetDate, List<MoodBase> moods){
        this.message = tweetMessage;
        this.date = tweetDate;
        this.moods = moods;
    }

    @Override
    public String toString(){
        String result = date.toString() + " | " + message;
        for (MoodBase mood : moods)
            result += " : " + mood.getRepresentation();
        return result;
    }

    public void setDate(Date newDate){
        date = newDate;
    }

    public Date getDate(){
        return date;
    }

    public void setMessage(String msg) throws TweetTooLongException {
        if (msg.length() <= MAX_TWEET_LENGTH){
            message = msg;
        } else {
            throw new TweetTooLongException();
        }
    }

    public String getMessage(){
        return message;
    }

    public abstract boolean isImportant();

}
