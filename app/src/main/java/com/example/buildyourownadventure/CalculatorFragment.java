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
import android.widget.TextView;
import android.widget.Toast;

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

    EditText numberValue1;
    EditText numberValue2;
    TextView operatorLabel;
    TextView resultLabel;
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
    Button subtractButton;
    Button divideButton;
    Button multiplyButton;
    Button dotButton;
    Button clearButton;
    Button equalsButton;
    Button modulusButton;
    Button backToDashboardButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        getActivity().setTitle("Calculator");

        numberValue1 = view.findViewById(R.id.numberValue1);
        numberValue2 = view.findViewById(R.id.numberValue2);
        operatorLabel = view.findViewById(R.id.operatorLabel);
        resultLabel = view.findViewById(R.id.resultLabel);
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
        subtractButton = view.findViewById(R.id.subtractButton);
        divideButton = view.findViewById(R.id.divideButton);
        multiplyButton = view.findViewById(R.id.multiplyButton);
        dotButton = view.findViewById(R.id.dotButton);
        clearButton = view.findViewById(R.id.clearButton);
        equalsButton = view.findViewById(R.id.equalsButton);
        modulusButton = view.findViewById(R.id.modulusButton);
        backToDashboardButton = view.findViewById(R.id.backToDashboardButton);

        /*
        All number buttons 0-9 will check the following:
        If editText numberValue1 is empty, put # into numberValue1
        Else put # into editText numberValue2
         */

        zeroButton.setOnClickListener(viewZero -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("0");
            } else {
                numberValue2.setText("0");
            }
        });

        oneButton.setOnClickListener(viewOne -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("1");
            } else {
                numberValue2.setText("1");
            }
        });

        twoButton.setOnClickListener(viewTwo -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("2");
            } else {
                numberValue2.setText("2");
            }
        });

        threeButton.setOnClickListener(viewThree -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("3");
            } else {
                numberValue2.setText("3");
            }
        });

        fourButton.setOnClickListener(viewFour -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("4");
            } else {
                numberValue2.setText("4");
            }
        });

        fiveButton.setOnClickListener(viewFive -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("5");
            } else {
                numberValue2.setText("5");
            }
        });

        sixButton.setOnClickListener(viewSix -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("6");
            } else {
                numberValue2.setText("6");
            }
        });

        sevenButton.setOnClickListener(viewSeven -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("7");
            } else {
                numberValue2.setText("7");
            }
        });

        eightButton.setOnClickListener(viewEight -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("8");
            } else {
                numberValue2.setText("8");
            }
        });

        nineButton.setOnClickListener(viewNine -> {
            if(numberValue1.getText().toString().isEmpty()) {
                numberValue1.setText("9");
            } else {
                numberValue2.setText("9");
            }
        });

        /*
        All operator buttons will set the text of the TextView operatorLabel to their operator value
         */

        addButton.setOnClickListener(viewAdd -> operatorLabel.setText("+"));

        subtractButton.setOnClickListener(viewSub -> operatorLabel.setText("-"));

        divideButton.setOnClickListener(viewDiv -> operatorLabel.setText("÷"));

        multiplyButton.setOnClickListener(viewMultiply -> operatorLabel.setText("*"));

        modulusButton.setOnClickListener(viewMod -> operatorLabel.setText("%"));

        /*
        //TODO
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
         */

        //Clear numbers, operator, and result
        clearButton.setOnClickListener(viewClear -> {
            numberValue1.setText("");
            numberValue2.setText("");
            operatorLabel.setText("");
            resultLabel.setText("");
        });

        /*
         This function will evaluate an expression with the following format:
         numberValue1 as the first operand
         numberValue2 as the second operand
         operatorLabel as the operator
         The result will be placed into the TextView resultsLabel

         The function will also display Toast messages if numberValue1, numberValue2, or the operator is left empty
        */
        equalsButton.setOnClickListener(viewEquals -> {
            String num1 = numberValue1.getText().toString();
            String num2 = numberValue2.getText().toString();
            if(num1.isEmpty()) {
                Toast.makeText(getContext(), "Enter the first number.", Toast.LENGTH_SHORT).show();
            } else if (num2.isEmpty()) {
                Toast.makeText(getContext(), "Enter the second number.", Toast.LENGTH_SHORT).show();
            } else {
                String operator = operatorLabel.getText().toString();
                if (!operator.isEmpty()) {
                    Double numDouble1 = Double.parseDouble(num1);
                    Double numDouble2 = Double.parseDouble(num2);
                    if(operator.equals("+")) {
                        Double result = numDouble1 + numDouble2;
                        resultLabel.setText(result.toString());
                    } else if(operator.equals("-")) {
                        Double result = numDouble1 - numDouble2;
                        resultLabel.setText(result.toString());
                    } else if(operator.equals("*")) {
                        Double result = numDouble1 * numDouble2;
                        resultLabel.setText(result.toString());
                    } else if(operator.equals("÷")) {
                        Double result = numDouble1 / numDouble2;
                        resultLabel.setText(result.toString());
                    } else if(operator.equals("%")) {
                        Double result = numDouble1 % numDouble2;
                        resultLabel.setText(result.toString());
                    }
                } else {
                    Toast.makeText(getContext(), "Select one of the operators: +,-,*,÷,%", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backToDashboardButton.setOnClickListener(viewBack -> calculatorListener.backToDashboard());

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