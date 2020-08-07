package com.example.fellbrook.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fellbrook.R;

public class MainActivity extends AppCompatActivity {

    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //nameField = (EditText)findViewById(R.id.nameEditText);
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //        String name = nameField.getText().toString();
                startStory();
            }
        });
    }

    private void startStory() {
        Intent intent = new Intent(this, StoryActivity.class);
        //Resources resources = getResources();
        startActivity(intent);

    }
}