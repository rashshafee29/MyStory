package com.example.user.mystory;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddStoryActivity extends AppCompatActivity {

    EditText storyTitle, storyAbout, storyText;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story);

        storyTitle = (EditText)findViewById(R.id.storyTitle);
        storyAbout = (EditText)findViewById(R.id.storyAbout);
        storyText = (EditText)findViewById(R.id.storyText);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = storyTitle.getText().toString();
                String about = storyAbout.getText().toString();
                String text = storyText.getText().toString();

                DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
                String date = df.format(Calendar.getInstance().getTime());

                if(title.length()!=0 && text.length()!=0 && about.length()!=0){
                    Intent newIntent = getIntent();
                    newIntent.putExtra("tag_story_title", title);
                    newIntent.putExtra("tag_story_about", title);
                    newIntent.putExtra("tag_date_time", date);
                    newIntent.putExtra("tag_story_title", title);
                    
                    setResult(AddStoryActivity.RESULT_OK, newIntent);
                    finish();
                }
            }
        });
    }
}
