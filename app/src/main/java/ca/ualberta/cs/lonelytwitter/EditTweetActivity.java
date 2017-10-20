package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditTweetActivity extends Activity {

    public static final String ID_NAME = "Name";
    public static final String ID_INDEX = "Index";

    private int index;

    EditText valueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

        Intent intent = getIntent();
        index = intent.getIntExtra(ID_INDEX, 0);

        valueText = (EditText) findViewById(R.id.msgEditText);
        valueText.setText(intent.getStringExtra(ID_NAME));

    }

    public void onFinishButtonClicked(View view){

        Intent intent = new Intent();

        intent.putExtra(ID_NAME, valueText.getText().toString());
        intent.putExtra(ID_INDEX, index);

        setResult(Activity.RESULT_OK, intent);
        finish();

    }
}