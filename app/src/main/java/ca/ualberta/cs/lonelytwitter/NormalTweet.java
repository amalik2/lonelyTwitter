package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by malik2 on 9/14/17.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String tweetMessage) {
        super(tweetMessage);
    }

    public NormalTweet(String tweetMessage, Date tweetDate) {
        super(tweetMessage, tweetDate);
    }

    public NormalTweet(String tweetMessage, Date tweetDate, List<MoodBase> moods) {
        super(tweetMessage, tweetDate, moods);
    }

    @Override
    public boolean isImportant() {
        return false;
    }
}
