package com.example.navdrawerapp.ui.doicoso;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.navdrawerapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link doicosoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class doicosoFragment extends Fragment {
    TextView input, output;
    Spinner from, to;
    String in, coso1,coso2;

    public doicosoFragment() {
        // Required empty public constructor
    }

    public static doicosoFragment newInstance() {
        doicosoFragment fragment = new doicosoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        in = "0";
        coso1 = "Nhị phân";
        coso2 = "Nhị phân";
        input = getView().findViewById(R.id.vFrom);
        output = getView().findViewById(R.id.result);

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

        from = (Spinner) getView().findViewById(R.id.spinnerFrom);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(view.getContext(), R.array.coso, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        from.setAdapter(adapter1);
        to = (Spinner) getView().findViewById(R.id.spinnerTo);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(view.getContext(), R.array.coso, R.layout.support_simple_spinner_dropdown_item);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doicoso, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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