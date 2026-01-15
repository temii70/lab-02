package com.example.listycity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button addCity;
    Button deleteCity;
    EditText cityInput;

    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        cityList = findViewById(R.id.city_list);
        cityInput = findViewById(R.id.city_input);
        addCity = findViewById(R.id.add_city_button);
        deleteCity = findViewById(R.id.delete_city_button);

        dataList = new ArrayList<>();
        dataList.add("Edmonton");
        dataList.add("Montréal");

        cityAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dataList
        );
        cityList.setAdapter(cityAdapter);


        addCity.setOnClickListener(v -> {
            String city = cityInput.getText().toString();

            if (!city.isEmpty()) {
                dataList.add(city);
                cityAdapter.notifyDataSetChanged();
                cityInput.setText("");
            }
        });

        cityList.setOnItemClickListener((parent, view, position, id) -> {
            index = position;
        });



        deleteCity.setOnClickListener(v -> {
            if (index != -1) {
                dataList.remove(index);
                cityAdapter.notifyDataSetChanged();
                index = -1;
            }
        });


    }
}