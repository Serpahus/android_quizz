package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = findViewById(R.id.spinner);
                String selected = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
    }


    public void sendMessage(View view) {
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        Spinner spinner   = (Spinner) findViewById(R.id.spinner);
        Spinner spinner2   = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3   = (Spinner) findViewById(R.id.spinner3);
        Spinner spinner4   = (Spinner) findViewById(R.id.spinner4);
        Spinner spinner5   = (Spinner) findViewById(R.id.spinner5);
        Button button2    = (Button) findViewById(R.id.button2);
        EditText editText = (EditText) findViewById(R.id.editText);

        String to = "email_employee";
        String subject = "Тестирование сотрудника" + ":" + editText.getText();
        String message = textView3.getText() + ":" + spinner.getSelectedItem().toString()  + "\n" +
                String.join(":", textView4.getText() , spinner2.getSelectedItem().toString()) + "\n" +
                String.join(":",textView5.getText() ,spinner3.getSelectedItem().toString()) + "\n" +
                String.join(":",textView6.getText() ,spinner4.getSelectedItem().toString()) + "\n" +
                String.join(":",textView7.getText() ,spinner5.getSelectedItem().toString());

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{to});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT   , message);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}




