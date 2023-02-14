package com.example.manipulating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        private TextView textView;
        private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
    }
        public void buttonPut(View view){
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.clear();
            editor.putString("stringUserData", editText.getText().toString());
            editor.putString("stringProgrammingWorld", "This is programmingworld");
            editor.apply();
        }
        public void buttonGet(View view){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String stringSharedPref_UserData = sharedPreferences.getString("StringUserData",null);
        String stringSharedPref_PWorld = sharedPreferences.getString("StringProgrammingWorld",null);

        if(stringSharedPref_PWorld == null &&
            stringSharedPref_UserData == null){
            textView.setText("Shared Preference Vaiables do not exist");
        }
        else{
            textView.setText(stringSharedPref_PWorld+"\n"+stringSharedPref_UserData);
        }
        }
        public void buttonDeleteAll(View view){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
        }
        public void buttonDelete(View view){
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        sharedPreferences.edit().remove("stringUserData").commit();
        }
    }
