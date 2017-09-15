package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by malik2 on 9/14/17.
 */

public abstract class MoodBase {

    private Date date;

    public MoodBase(){
        date = new Date(System.currentTimeMillis());
    }

    public MoodBase(Date dateArg){
        date = dateArg;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date newDate){
        date = newDate;
    }

    /**
     * @return a description of this Mood
     */
    public abstract String getRepresentation();

    /**
     * @return a new MoodBase object that is a copy of the current one
     */
    public abstract MoodBase clone();

}
