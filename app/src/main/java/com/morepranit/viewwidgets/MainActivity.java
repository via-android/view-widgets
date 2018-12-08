package com.morepranit.viewwidgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries.add("India");
        countries.add("USA");
        countries.add("Germany");
        countries.add("Australia");

        Spinner spnCountries = findViewById(R.id.spn_countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCountries.setAdapter(adapter);

        spnCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You selected " + adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onCheckboxClick(View view) {
        int id = view.getId();
        boolean isChecked = ((CheckBox) view).isChecked();

        switch (id) {
            case R.id.cb_cricket:
                if (isChecked)
                    Toast.makeText(this, "Your checked Cricket", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Your unchecked Cricket", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cb_football:
                if (isChecked)
                    Toast.makeText(this, "Your checked Football", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Your unchecked Football", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void onRadioButtonClick(View view) {
        int id = view.getId();
        boolean isChecked = ((RadioButton) view).isChecked();

        switch (id) {
            case R.id.rb_female:
                if (isChecked)
                    Toast.makeText(this, "Your checked Female", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_male:
                if (isChecked)
                    Toast.makeText(this, "Your checked Male", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
