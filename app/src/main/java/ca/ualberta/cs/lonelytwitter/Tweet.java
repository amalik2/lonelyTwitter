package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by malik2 on 9/14/17.
 */

public class Tweet {

    private String message;
    private Date date;
    private List<MoodBase> selectedMoods;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
        selectedMoods = new ArrayList<MoodBase>();
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
        selectedMoods = new ArrayList<MoodBase>();
    }

    public Tweet(String message, Date date, List<MoodBase> moods) {
        this.message = message;
        this.date = date;
        selectedMoods = moods;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        String fileData = new String(date.toString() + " | " + message);
        // Save data for all moods
        for (MoodBase mood : selectedMoods){
            fileData += ", MOOD: " + mood.getRepresentation() + "(" + mood.getDate().toString() + ")";
        }
        return fileData;
    }
}