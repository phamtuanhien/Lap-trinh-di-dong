package com.example.navdrawerapp.ui.calc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.navdrawerapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalcFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalcFragment extends Fragment {
    private TextView minor;
    private TextView major;
    private StringBuilder stringBuilder;
    private String operator;
    private boolean needClearMajor;
    private boolean canClearResult;

    public CalcFragment() {
        // Required empty public constructor
    }

    public static CalcFragment newInstance() {
        CalcFragment fragment = new CalcFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        minor = getView().findViewById(R.id.input);
        major = getView().findViewById(R.id.output);
        stringBuilder = new StringBuilder();
        operator = "";
        needClearMajor = false;
        canClearResult = false;

        View.OnClickListener onClickNum = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickNum(view);
            }
        };

        View.OnClickListener onClickOperator = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickOperator(view);
            }
        };

        View.OnClickListener onClickDel = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDel(view);
            }
        };

        View.OnClickListener onClickC = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickC(view);
            }
        };

        View.OnClickListener onClickEqual = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEqual(view);
            }
        };

        Button num0=(Button) view.findViewById(R.id.num0);
        num0.setOnClickListener(onClickNum);
        Button num1=(Button) view.findViewById(R.id.num1);
        num1.setOnClickListener(onClickNum);
        Button num2=(Button) view.findViewById(R.id.num2);
        num2.setOnClickListener(onClickNum);
        Button num3=(Button) view.findViewById(R.id.num3);
        num3.setOnClickListener(onClickNum);
        Button num4=(Button) view.findViewById(R.id.num4);
        num4.setOnClickListener(onClickNum);
        Button num5=(Button) view.findViewById(R.id.num5);
        num5.setOnClickListener(onClickNum);
        Button num6=(Button) view.findViewById(R.id.num6);
        num6.setOnClickListener(onClickNum);
        Button num7=(Button) view.findViewById(R.id.num7);
        num7.setOnClickListener(onClickNum);
        Button num8=(Button) view.findViewById(R.id.num8);
        num8.setOnClickListener(onClickNum);
        Button num9=(Button) view.findViewById(R.id.num9);
        num9.setOnClickListener(onClickNum);

        Button mul= (Button) view.findViewById(R.id.mul);
        mul.setOnClickListener(onClickOperator);
        Button plus= (Button) view.findViewById(R.id.plus);
        plus.setOnClickListener(onClickOperator);
        Button minus= (Button) view.findViewById(R.id.minus);
        minus.setOnClickListener(onClickOperator);
        Button div= (Button) view.findViewById(R.id.div);
        div.setOnClickListener(onClickOperator);

        Button equal = (Button) view.findViewById(R.id.equal);
        equal.setOnClickListener(onClickEqual);
        Button btnC = (Button) view.findViewById(R.id.C);
        btnC.setOnClickListener(onClickC);
        Button del = (Button) view.findViewById(R.id.del);
        del.setOnClickListener(onClickDel);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calc, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onClickDel(View view) {
        if (stringBuilder.length() > 0 ) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            major.setText(stringBuilder.toString());
        }
        if (stringBuilder.length() == 0) {
            stringBuilder = new StringBuilder("0");
            major.setText(stringBuilder.toString());
        }
    }

    public void onClickC(View view) {
        stringBuilder = new StringBuilder();
        operator = "";
        needClearMajor = false;
        canClearResult = false;
        minor.setText("");
        major.setText("0");
    }

    public void onClickNum(View view) {
        if (!minor.getText().toString().isEmpty() && needClearMajor == true) {
            needClearMajor = false;
            stringBuilder = new StringBuilder();
        }
        if (minor.getText().toString().isEmpty() && canClearResult == true) {
            canClearResult = false;
            stringBuilder = new StringBuilder();
        }
        stringBuilder.append(((Button)view).getText());
        major.setText(stringBuilder.toString());
    }

    public void onClickOperator(View view) {
        if (minor.getText().toString().isEmpty()) {
            stringBuilder.append(((Button)view).getText());
            minor.setText(stringBuilder.toString());
            operator = ((Button)view).getText().toString();
            needClearMajor = true;
        } else {
            if (needClearMajor) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                stringBuilder.append(((Button)view).getText());
                minor.setText(stringBuilder.toString());
                operator = ((Button)view).getText().toString();
            } else {
                onClickEqual(getView().findViewById(R.id.equal));
                stringBuilder.append(((Button)view).getText());
                minor.setText(stringBuilder.toString());
                operator = ((Button)view).getText().toString();
                needClearMajor = true;
            }
        }
    }

    public static String removeLastCharacter(String str) {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
            result = str.substring(0, str.length() - 1);
        }
        return result;
    }
    public void onClickEqual(View view) {
        System.out.println(operator);
        int result = 0;
        if (operator.equals("+")) {
            result = Integer.parseInt(removeLastCharacter(minor.getText().toString())) + Integer.parseInt(major.getText().toString());
        }
        if (operator.equals("-")) {
            result = Integer.parseInt(removeLastCharacter(minor.getText().toString())) - Integer.parseInt(major.getText().toString());
        }
        if (operator.equals("×")) {
            result = Integer.parseInt(removeLastCharacter(minor.getText().toString())) * Integer.parseInt(major.getText().toString());
        }
        if (operator.equals("÷")) {
            result = Integer.parseInt(removeLastCharacter(minor.getText().toString())) + Integer.parseInt(major.getText().toString());
        }
        System.out.println(result);
        minor.setText("");
        major.setText(Integer.toString(result));
        stringBuilder = new StringBuilder(major.getText().toString());
        canClearResult = true;
    }
}