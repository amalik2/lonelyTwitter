package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
        Log.d("SETUP", "setUp()");
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    /*public void testTweet(){
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        solo.enterText((EditText)solo.getView(R.id.body), "Test Tweet!");

        // text on button
        solo.clickOnButton("Save");
        solo.clearEditText((EditText)solo.getView(R.id.body));
        // wait until that text is on the screen somewhere
        assertTrue(solo.waitForText("Test Tweet!", 1, 1000));
        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!", 1, 1000));
    }

    public void testClickTweetList(){

	    LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet)oldTweetsList.getItemAtPosition(0);
        //assertEquals("Test Tweet!", tweet.getMessage());

        solo.clickInList(0);
        solo.assertCurrentActivity("wrong activity", EditTweetActivity.class);

        assertFalse(solo.waitForText("New Activity", 1, 1000));
        solo.goBack();
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class);
    }*/

    public void testEditTweet(){

        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet)oldTweetsList.getItemAtPosition(0);

        solo.clickInList(0);
        solo.assertCurrentActivity("wrong activity", EditTweetActivity.class);
        solo.clearEditText((EditText)solo.getView(R.id.msgEditText));
        solo.enterText((EditText)solo.getView(R.id.msgEditText), "Test Tweet!");
        assertTrue(solo.waitForText("Test Tweet!", 1, 1000));
        solo.clickOnButton("Finish");
        solo.assertCurrentActivity("wrong activity", LonelyTwitterActivity.class);

        assertEquals("Test Tweet!", tweet.getMessage());
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

}
