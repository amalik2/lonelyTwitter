package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malik2 on 9/14/17.
 */

public class MoodOne extends MoodBase {

    public MoodOne() {
        super();
    }

    public MoodOne(Date dateArg) {
        super(dateArg);
    }

    /**
     * @return a description of this Mood
     */
    @Override
    public String getRepresentation() {
        return "Mood One";
    }

    @Override
    public MoodBase clone(){
        return new MoodOne();
    }
}
