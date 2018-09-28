package com.example.hp.legendaryquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {
    //* This code initializes the score variable*//
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//* The following holds instances of all legendaryQuiz  valid data entry points*//
        final EditText nameField = (EditText) findViewById(R.id.name_field);
        final EditText ngr = (EditText) findViewById(R.id.naija_capital);
        final EditText rus = (EditText) findViewById(R.id.russia_capital);
        final RadioGroup rg1 = (RadioGroup) findViewById(R.id.rg1);
        final RadioGroup rg2 = (RadioGroup) findViewById(R.id.rg2);
        final RadioGroup rg3 = (RadioGroup) findViewById(R.id.rg3);
        final CheckBox nig = (CheckBox) findViewById(R.id.naija);
        final CheckBox egy = (CheckBox) findViewById(R.id.egypt);
        final CheckBox eth = (CheckBox) findViewById(R.id.ethiopia);
        final CheckBox ghn = (CheckBox) findViewById(R.id.ghana);
        final CheckBox cristiano = (CheckBox) findViewById(R.id.cristiano);
        final CheckBox roberto = (CheckBox) findViewById(R.id.baggio);
        final CheckBox ronaldh = (CheckBox) findViewById(R.id.ronaldinho);
        final CheckBox lionel = (CheckBox) findViewById(R.id.messi);
//* This line of code identifies, intializes and holds an instance of the of the reset button*//
        Button btn = (Button) findViewById(R.id.reset);
//* This method call rests all data entry points on legendaryQuiz *//
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
// The following lines resets every valid data interaction points on LegendaryQuiz App**//
                nameField.setText("");
                ngr.getText().clear();
                rus.setText("");
                rg1.clearCheck();
                rg2.clearCheck();
                rg3.clearCheck();
                nig.setChecked(false);
                egy.setChecked(false);
                eth.setChecked(false);
                ghn.setChecked(false);
                cristiano.setChecked(false);
                roberto.setChecked(false);
                ronaldh.setChecked(false);
                lionel.setChecked(false);
                score = 0;
                display("Attempt all Questions before You Submit");
            }
        });
    }

    /*** This Method Displays Text(student's name and Total score) on TextView**/
    public void display(String message) {
        TextView gradeTextView = (TextView) findViewById(R.id.grade_view);
        gradeTextView.setText(message);
    }

    /*** This Method is called when submit button is clicked**/
    public void submit(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        EditText ngr = (EditText) findViewById(R.id.naija_capital);
        String ngrCap = ngr.getText().toString().trim();

        EditText rus = (EditText) findViewById(R.id.russia_capital);
        String rusCap = rus.getText().toString().trim();

        CheckBox lionel = (CheckBox) findViewById(R.id.messi);
        Boolean lionelMessi = lionel.isChecked();

        CheckBox cristiano = (CheckBox) findViewById(R.id.cristiano);
        Boolean cristianoRonaldo = cristiano.isChecked();

        CheckBox ronaldh = (CheckBox) findViewById(R.id.ronaldinho);
        Boolean ronaldinho = cristiano.isChecked();

        CheckBox nig = (CheckBox) findViewById(R.id.naija);
        Boolean abj = nig.isChecked();

        CheckBox egy = (CheckBox) findViewById(R.id.egypt);
        Boolean car = egy.isChecked();

        CheckBox eth = (CheckBox) findViewById(R.id.ethiopia);
        Boolean drs = eth.isChecked();

        CheckBox ghn = (CheckBox) findViewById(R.id.ghana);
        Boolean acc = ghn.isChecked();

        name = "Name: " + name + "\nFinal Score: " + calculateGrade(abj, acc, ngrCap, rusCap, cristianoRonaldo, lionelMessi, ronaldinho);
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
        display(name);
        score = 0;
    }

    //** This method aggregates all scores obtainable on legendaryQuiz**//
    private int calculateGrade(Boolean n, Boolean g, String ngrCap, String rusCap, Boolean cr7, boolean lio, boolean ron) {
        CheckBox nig = (CheckBox) findViewById(R.id.naija);
        Boolean abj = nig.isChecked();
        CheckBox ghn = (CheckBox) findViewById(R.id.ghana);
        Boolean acc = ghn.isChecked();
        CheckBox egy = (CheckBox) findViewById(R.id.egypt);
        Boolean car = egy.isChecked();
        CheckBox eth = (CheckBox) findViewById(R.id.ethiopia);
        Boolean drs = eth.isChecked();

        if (abj == true  && acc == true  && !car == true && !drs == true  ) {
            score = score + 6;
        }

        else if (car == true) {
            score = score - 5;
        }

        else if (drs == true) {
            score = score - 5;
        }

        if (ngrCap.equalsIgnoreCase("Abuja")) {
            score = score + 10;
        }

        if (rusCap.equalsIgnoreCase("Moscow")) {
            score = score + 10;
        }

        CheckBox cristiano = (CheckBox) findViewById(R.id.cristiano);
        Boolean cristianoRonaldo = cristiano.isChecked();
        CheckBox lionel = (CheckBox) findViewById(R.id.messi);
        Boolean lionelMessi = lionel.isChecked();
        CheckBox ronaldh = (CheckBox) findViewById(R.id.ronaldinho);
        Boolean ronaldinho = cristiano.isChecked();
        CheckBox roberto = (CheckBox) findViewById(R.id.baggio);
        Boolean robertoBaggio = roberto.isChecked();

        if (cristianoRonaldo == true    && lionelMessi == true && ronaldinho == true && !robertoBaggio == true) {
            score = score + 9;
        }

        else if (robertoBaggio == true) {
            score = score - 5;
        }

        RadioButton uk = (RadioButton) findViewById(R.id.elizabeth);
        boolean ukMonarch = uk.isChecked();
        if (ukMonarch == true) {
            score = score + 5;
        }

        RadioButton newDeal = (RadioButton) findViewById(R.id.roosevelt);
        boolean americanNewDeal = newDeal.isChecked();
        if (americanNewDeal == true) {
            score = score + 5;
        }

        RadioButton president = (RadioButton) findViewById(R.id.azikiwe);
        boolean firstPresident = president.isChecked();
        if (firstPresident == true) {
            score = score + 5;
        }

        if (score > 50) {
            Toast.makeText(this, "You should RESET the Quiz", Toast.LENGTH_SHORT).show();
            score = 0;
        }
        return score;
    }
}
