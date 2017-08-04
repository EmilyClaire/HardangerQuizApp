package com.example.android.hardangerquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.R.attr.checked;

public class MainActivity extends AppCompatActivity {
    private int[] questions = {0, 0, 0, 0};

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
        msg += "\nYou scored " + sumScore() + " / " + questions.length + " !";

        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
                .show();
    }

    private int sumScore() {
        int sum = 0;

        for (int i = 0; i < questions.length; i++) {
            sum += questions[i];
        }

        return sum;
    }


    /**
     * Sets the point value for question 1 as 1 if correct or 0 if incorrect.
     *
     * @param view
     */
    public void scoreQuestion1(View view) {
        RadioButton button = ((RadioButton) view);

        if (button.isChecked()) {
            if (view.getId() == R.id.q_1_doves) {
                questions[0] = 1;
            } else {
                questions[0] = 0;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        EditText editText = (EditText) findViewById(R.id.name);
        String name = editText.getText().toString();

        savedInstanceState.putIntArray("questions", questions);
        savedInstanceState.putString("name", name);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        EditText editText = (EditText) findViewById(R.id.name);
        questions = savedInstanceState.getIntArray("questions");
        String name = savedInstanceState.getString("name");
        editText.setText(name);
    }

}
