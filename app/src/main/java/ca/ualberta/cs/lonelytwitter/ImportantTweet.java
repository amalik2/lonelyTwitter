package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by malik2 on 9/14/17.
 */

public class ImportantTweet extends Tweet {

    public ImportantTweet(String message){
        super(message);
    }

    public ImportantTweet(String message, Date date){
        super(message, date);
    }

    public ImportantTweet(String tweetMessage, Date tweetDate, List<MoodBase> moods) {
        super(tweetMessage, tweetDate, moods);
    }

    @Override
    public boolean isImportant() {
        return true;
    }
}
