package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malik2 on 9/14/17.
 */

public class MoodTwo extends MoodBase {

    public MoodTwo() {
        super();
    }

    public MoodTwo(Date dateArg) {
        super(dateArg);
    }

    /**
     * @return a description of this Mood
     */
    @Override
    public String getRepresentation() {
        return "Mood Two";
    }

    @Override
    public MoodBase clone(){
        return new MoodTwo();
    }
}
