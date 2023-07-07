package com.example.day_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String oldNumber ;
    String newNumber;
    String arithmeticOperation = "";
    boolean isDot = false;
    EditText editText;
    Button AC;
    boolean isNull = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.numberController);
        AC = findViewById(R.id.buttonAC);

    }

    public void onTapNumber(View view) {
        if(isNull){
            editText.setText("");
            AC.setText("C");
            isNull = false;
            isDot = false;
        }

        String number = editText.getText().toString();

        switch (view.getId()){
            case R.id.buttonOne:
                number = number + "1";
                break;
            case R.id.buttonTwo:
                number = number + "2";
                break;
            case R.id.buttonThree:
                number = number + "3";
                break;
            case R.id.buttonFour:
                number = number + "4";
                break;
            case R.id.buttonFive:
                number = number + "5";
                break;
            case R.id.buttonSix:
                number = number + "6";
                break;
            case R.id.buttonSeven:
                number = number + "7";
                break;
            case R.id.buttonEight:
                number = number + "8";
                break;
            case R.id.buttonNine:
                number = number + "9";
                break;
            case R.id.buttonZero:
                number +="0";

                break;
        }

        editText.setText(number);



    }

    public void arithmetic(View view) {
        oldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.buttonPlus:
                arithmeticOperation = "+";
                isNull = true;
                break;
            case  R.id.buttonMinus:
                arithmeticOperation = "-";
                isNull = true;
                break;
            case R.id.buttonDiv:
                arithmeticOperation = "/";
                isNull = true;
                break;
            case R.id.buttonMul:
                arithmeticOperation = "*";
                isNull = true;
                break;
        }
    }

    public void result(View view) {
        newNumber = editText.getText().toString();
        Double Result = 0.0;

        switch (arithmeticOperation){
            case "+":
                Result = Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                Result = Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "*":
                Result = Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case "/":
                Result = Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        editText.setText(Result.toString());
    }

    public void Clean(View view) {
        if(editText.getText().toString()!="0"){
            editText.setText("0");
            AC.setText("AC");
            isDot = false;
            isNull = true;
        }
    }

    public void modul(View view) {
        Double currentNumber = Double.parseDouble(editText.getText().toString());
        currentNumber*=-1;
        editText.setText(currentNumber.toString());
    }

    public void CalculatePercent(View view) {
        if(arithmeticOperation==""){
            oldNumber = editText.getText().toString();
            Double Res = Double.parseDouble(oldNumber)/100;
            editText.setText(Res.toString());
        }
        else{
            Double Result = 0.0;
            newNumber = editText.getText().toString();
            switch (arithmeticOperation){
                case "+":
                    Result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    break;
                case "-":
                    Result =Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    break;
                case "*":
                    Result =Double.parseDouble(newNumber)/100;
                    break;
                case "/":
                    Result = Double.parseDouble(newNumber)/100;
                    break;
            }
            editText.setText(Result.toString());
        }

    }

    public void onTapDot(View view) {
        if(!isDot){
            editText.setText(editText.getText() + ".");
            isDot = true;
        }
    }
}