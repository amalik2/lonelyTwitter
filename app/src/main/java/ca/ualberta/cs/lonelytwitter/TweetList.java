package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malik2 on 10/12/17.
 */

public class TweetList {

    private List<Tweet> tweets;

    public TweetList(){
        tweets = new ArrayList<Tweet>();
    }

    public void addTweet(Tweet tweet) throws IllegalArgumentException {
        if (hasTweet(tweet))
            throw new IllegalArgumentException();
        tweets.add(tweet);
    }

    public List<Tweet> getTweets(){
        return tweets;
    }

    public boolean hasTweet(Tweet tweet){
        /*for (Tweet it : tweets){
            if (it.equals(tweet))
                return true;
        }
        return false;*/
        return tweets.contains(tweet);
    }

    public int getCount(){
        return tweets.size();
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

}
