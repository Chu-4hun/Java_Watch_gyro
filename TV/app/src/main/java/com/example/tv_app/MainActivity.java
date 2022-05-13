package com.example.tv_app;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {
    ListView lst;
    String[] devices = {"Планшеты", "Телефоны", "Ноутбуки", "Компьютеры"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, devices
        );
        lst.setAdapter(adapter);

        lst.setOnItemClickListener((adapterView, view, id, l) -> {
                    SparseBooleanArray checkedItems = lst.getCheckedItemPositions();
                    StringBuilder selectedItems = new StringBuilder();
                    for (int i = 0; i < devices.length; i++) {
                        if (checkedItems.get(i)) {
                            selectedItems.append(devices[i]).append(",");
                        }
                    }
                    Toast.makeText(getApplicationContext(), selectedItems.toString(), Toast.LENGTH_SHORT).show();
                }
        );
    }
}