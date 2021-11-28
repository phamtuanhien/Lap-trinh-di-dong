package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ItemEmailModel> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        items = new ArrayList<>();
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:33 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:34 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:35 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:36 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:37 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:38 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:39 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:40 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:41 PM"));
        items.add(new ItemEmailModel(R.drawable.a, "Evan Evil", "$19 Only (First 10 spots) - Bestselling... Are you looking to Learn Web Designing", "11:42 PM"));

        ItemAdapter adapter = new ItemAdapter(items);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

}