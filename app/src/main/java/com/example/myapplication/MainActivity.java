package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.EditorInfo;
import android.view.KeyEvent;


public class MainActivity extends AppCompatActivity {
    TextView text;
    TextView updateText;
    EditText updateField;
    EditText updateByEnter;
    Context context = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = MainActivity.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.helloText); //textview for helloworld
        updateText = findViewById(R.id.updateText); //textview for user input prints
        updateField = findViewById(R.id.enterText); //input and button press textarea
        updateByEnter = findViewById(R.id.updateByEnter); //input and enter textarea
        updateByEnter.setOnEditorActionListener(enterListener); //enterlistener
    }

    public void helloWorldButton(View view) {
        System.out.println("Hello World!");
    }

    public void changeTextField(View view) {
        text.setText("Hello World!");
    }

    public void updateTextBox(View view) {
        String text = updateField.getText().toString();
        updateText.setText(text);
    }

    //https://stackoverflow.com/questions/1489852/android-handle-enter-in-an-edittext
    //http://androidsbs.blogspot.com/2013/05/perform-action-after-enter-keypress-on.html
    TextView.OnEditorActionListener enterListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_NULL || actionId == EditorInfo.IME_ACTION_DONE) {
                String text = updateByEnter.getText().toString();
                updateText.setText(text);
                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            return true;
        }
    };

}