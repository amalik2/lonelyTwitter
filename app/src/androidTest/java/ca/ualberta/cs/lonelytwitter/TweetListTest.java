package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.List;

/**
 * Created by malik2 on 10/12/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        //assertTrue(Boolean.TRUE);
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding Tweet");
        tweets.addTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("xyz");
        tweets.addTweet(tweet);
        Tweet tweet2 = new NormalTweet("abc");
        tweets.addTweet(tweet2);

        List<Tweet> tweetsList = tweets.getTweets();
        assertTrue(tweets.getCount() == tweetsList.size());
        for (Tweet it : tweetsList)
            assertTrue(tweets.hasTweet(it));

        // reorder due to sort
        assertTrue(tweetsList.get(0) == tweet2);
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        assertTrue(tweets.getCount() == 0);
        Tweet tweet = new NormalTweet("adding Tweet");
        tweets.addTweet(tweet);
        assertTrue(tweets.getCount() == 1);

        tweets.delete(tweet);
        assertTrue(tweets.getCount() == 0);
    }

    public void testDelete(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding Tweet");
        tweets.addTweet(tweet);

        assertTrue(tweets.getCount() == 1);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding Tweet");
        tweets.addTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding Tweet");
        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(tweet.getMessage(), returnedTweet.getMessage());
    }
}
