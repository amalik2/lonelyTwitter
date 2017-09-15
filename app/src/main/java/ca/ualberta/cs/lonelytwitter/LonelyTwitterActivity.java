package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class LonelyTwitterActivity extends Activity {

	private static List<MoodBase> MOOD_BASE_LIST;
	// String that is at the end of all selected moods
	private static final String SELECTED_IDENTIFIER = " (Selected)";

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ListView moodsListView;

	private List<Long> selectedMoods;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		moodsListView = (ListView) findViewById(R.id.moodsList);

		initializeMoods();

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				// Added moods
				List<MoodBase> tweetMoods = new ArrayList<MoodBase>();
				for (long id : selectedMoods) {
					MoodBase newMood = MOOD_BASE_LIST.get(((int) id)).clone();
					newMood.setDate(new Date(System.currentTimeMillis()));
					tweetMoods.add(newMood);
				}

				saveInFile(text, new Date(System.currentTimeMillis()), tweetMoods);
				selectedMoods.clear();	// reset all modes associated with this tweet
				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile(String text, Date date, List<MoodBase> moods) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			String fileData = new String(date.toString() + " | " + text);
			// Save data for all moods
			for (MoodBase mood : moods){
				fileData += " : " + mood.getRepresentation();
			}

			fos.write(fileData.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the list containing the moods
	 */
	private void initializeMoods(){

		MOOD_BASE_LIST = new ArrayList<MoodBase>();
		MOOD_BASE_LIST.add(new MoodOne());
		MOOD_BASE_LIST.add(new MoodTwo());

		selectedMoods = new ArrayList<Long>();

		// Add description of each mood to the selectable list of moods
		String[] moodArray = new String[MOOD_BASE_LIST.size()];
		for (int i = 0; i < MOOD_BASE_LIST.size(); i++)
			moodArray[i] = MOOD_BASE_LIST.get(i).getRepresentation();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, moodArray);
		moodsListView.setAdapter(adapter);

		// Handle selecting a mood
		moodsListView.setOnItemClickListener(new ListView.OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				TextView text = (TextView)view;

				// TODO: add/remove * from view
				if (selectedMoods.contains(id)) {
					selectedMoods.remove(id);
					// remove the selected identifier from the text
				//	text.setText(text.getText().subSequence(0, text.length() - SELECTED_IDENTIFIER.length()));
					text.setSelected(true);
				}
				else {
					selectedMoods.add(id);
				//	text.setText(text.getText() + SELECTED_IDENTIFIER);
					text.setSelected(false);
				}

			}
		});

	}

}