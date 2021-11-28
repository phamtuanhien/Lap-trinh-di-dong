package com.example.chuyencoso;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView input, output;
    Spinner from, to;
    String in, coso1,coso2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in = "0";
        coso1 = "Nhị phân";
        coso2 = "Nhị phân";

        input = findViewById(R.id.vFrom);
        output = findViewById(R.id.result);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("")) {
                    output.setText("");
                }
                in = editable.toString();
                onChange();
            }
        });

        from = (Spinner) findViewById(R.id.spinnerFrom);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.coso, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        from.setAdapter(adapter1);
        to = (Spinner) findViewById(R.id.spinnerTo);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.coso, R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        to.setAdapter(adapter2);

        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getAdapter().getItem(i).toString();
                Log.v("LOG", item);
                coso1 = item;
                onChange();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getAdapter().getItem(i).toString();
                Log.v("LOG", item);
                coso2 = item;
                onChange();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    private void onChange() {
        try {
            if (coso1.equals(coso2)) {
                output.setText(input.getText());
            }
            if (coso1.equals("Nhị phân")) {
                int t = Integer.parseInt(in,2);
                switch (coso2) {
                    case "Bát phân":
                        output.setText(Integer.toString(t,8));
                        break;
                    case "Thập phân":
                        output.setText(Integer.toString(t,10));
                        break;
                    case "Thập lục phân":
                        output.setText(Integer.toString(t,16));
                        break;
                }
            } else if (coso1.equals("Bát phân")) {
                int t = Integer.parseInt(in,8);
                switch (coso2) {
                    case "Nhị phân":
                        output.setText(Integer.toString(t,2));
                        break;
                    case "Thập phân":
                        output.setText(Integer.toString(t,10));
                        break;
                    case "Thập lục phân":
                        output.setText(Integer.toString(t,16));
                        break;
                }
            } else if (coso1.equals("Thập phân")) {
                int t = Integer.parseInt(in,10);
                switch (coso2) {
                    case "Nhị phân":
                        output.setText(Integer.toString(t,2));
                        break;
                    case "Bát phân":
                        output.setText(Integer.toString(t,8));
                        break;
                    case "Thập lục phân":
                        output.setText(Integer.toString(t,16));
                        break;
                }
            } else if (coso1.equals("Thập lục phân")) {
                int t = Integer.parseInt(in,16);
                switch (coso2) {
                    case "Nhị phân":
                        output.setText(Integer.toString(t,2));
                        break;
                    case "Bát phân":
                        output.setText(Integer.toString(t,8));
                        break;
                    case "Thập phân":
                        output.setText(Integer.toString(t,10));
                        break;
                }
            }
        } catch (Exception err) {
        }
    }
}