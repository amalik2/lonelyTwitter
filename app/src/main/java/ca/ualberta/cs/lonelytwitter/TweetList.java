package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        //if (hasTweet(tweet))
        //  throw new IllegalArgumentException();
        for (Tweet it : tweets){
            if (it.getMessage().equals(tweet.getMessage()))
                throw new IllegalArgumentException();
        }
        tweets.add(tweet);
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(final Tweet object1, final Tweet object2) {
                return object1.getMessage().compareTo(object2.getMessage());
            }
        });
    }

    public List<Tweet> getTweets(){
        return tweets;
    }

    public boolean hasTweet(Tweet tweet){
        // this method uses equals as the internal comparator
        return tweets.contains(tweet);
    }

    public int getCount(){
        return tweets.size();
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

}
