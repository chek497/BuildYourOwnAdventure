package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorFragment extends Fragment {

    public CalculatorFragment() {
        // Required empty public constructor
    }

    public static CalculatorFragment newInstance() {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    EditText numberValue;
    Button zeroButton;
    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button addButton;
    Button subractButton;
    Button divideButton;
    Button multiplyButton;
    Button dotButton;
    Button equalsButton;
    Button leftParenthesesButton;
    Button rightParenthesesButton;
    Button modulusButton;
    Button exponentButton;
    Button backToDashboardButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        getActivity().setTitle("Calculator");

        numberValue = view.findViewById(R.id.numberValue);
        zeroButton = view.findViewById(R.id.zeroButton);
        oneButton = view.findViewById(R.id.oneButton);
        twoButton = view.findViewById(R.id.twoButton);
        threeButton = view.findViewById(R.id.threeButton);
        fourButton = view.findViewById(R.id.fourButton);
        fiveButton = view.findViewById(R.id.fiveButton);
        sixButton = view.findViewById(R.id.sixButton);
        sevenButton = view.findViewById(R.id.sevenButton);
        eightButton = view.findViewById(R.id.eightButton);
        nineButton = view.findViewById(R.id.nineButton);
        addButton = view.findViewById(R.id.addButton);
        subractButton = view.findViewById(R.id.subtractButton);
        divideButton = view.findViewById(R.id.divideButton);
        multiplyButton = view.findViewById(R.id.multiplyButton);
        dotButton = view.findViewById(R.id.dotButton);
        equalsButton = view.findViewById(R.id.equalsButton);
        leftParenthesesButton = view.findViewById(R.id.leftParenthesesButton);
        rightParenthesesButton = view.findViewById(R.id.rightParenthesesButton);
        modulusButton = view.findViewById(R.id.modulusButton);
        exponentButton = view.findViewById(R.id.exponentButton);
        backToDashboardButton = view.findViewById(R.id.backToDashboardButton);

        numberValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        zeroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        oneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        twoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        threeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        fourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        fiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        sixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        sevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        eightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        nineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        subractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        leftParenthesesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rightParenthesesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        modulusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        exponentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        backToDashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorListener.backToDashboard();
            }
        });

        return view;
    }

    ICalculatorListener calculatorListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICalculatorListener) {
            calculatorListener = (ICalculatorListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement ICalculatorListener");
        }
    }

    public interface ICalculatorListener{
        void backToDashboard();
    }

}