package com.example.android.hardangerquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Calculates and shows the users name and score as a toast message
     *
     * @param view
     */

    public void showScore(View view){
        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();
        String msg = "Congratulations " + name + "!";

        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();

        savedInstanceState.putString("name", name);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        EditText editText = (EditText) findViewById(R.id.name);
        String name = savedInstanceState.getString("name");

        editText.setText(name);
    }

}
