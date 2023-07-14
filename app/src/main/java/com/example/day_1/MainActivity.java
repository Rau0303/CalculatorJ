package com.example.day_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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
//кнопка цифры 1 2 3...
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
                if (number.equals("0")) {
                    number = "1";
                } else {
                    number += "1";
                }
                break;
            case R.id.buttonTwo:
                if (number.equals("0")) {
                    number = "2";
                } else {
                    number += "2";
                }
                break;
            case R.id.buttonThree:
                if (number.equals("0")) {
                    number = "3";
                } else {
                    number += "3";
                }
                break;
            case R.id.buttonFour:
                if (number.equals("0")) {
                    number = "4";
                } else {
                    number += "4";
                }
                break;
            case R.id.buttonFive:
                if (number.equals("0")) {
                    number = "5";
                } else {
                    number += "5";
                }
                break;
            case R.id.buttonSix:
                if (number.equals("0")) {
                    number = "6";
                } else {
                    number += "6";
                }
                break;
            case R.id.buttonSeven:
                if (number.equals("0")) {
                    number = "7";
                } else {
                    number += "7";
                }
                break;
            case R.id.buttonEight:
                if (number.equals("0")) {
                    number = "8";
                } else {
                    number += "8";
                }
                break;
            case R.id.buttonNine:
                if (number.equals("0")) {
                    number = "9";
                } else {
                    number += "9";
                }
                break;
            case R.id.buttonZero:
                if (!number.equals("0")) {
                    number += "0";
                }
                break;

        }
        String curNumber = sizeFormat(number);
        String formattedResult = formatResult(curNumber, 10);
        editText.setText(formattedResult);
    }
//кнопка ар + - * /
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
//кнопка =
    public void result(View view) {
        newNumber = editText.getText().toString();
        Double Result = 0.0;

        switch (arithmeticOperation){
            case "+":
                Result = Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                isDot = true;
                break;
            case "-":
                Result = Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                isDot = true;
                break;
            case "*":
                Result = Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                isDot = true;
                break;
            case "/":
                Result = Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                isDot = true;
                break;
        }

        String formattedResult = formatResult(Result.toString(), 10);

        editText.setText(formattedResult);
        arithmeticOperation = "";
    }
//кнопка АС
    public void Clean(View view) {
        if (!editText.getText().toString().equals("0")) {
            editText.setText("0");
            AC.setText("AC");
            isDot = false;
            isNull = true;
            editText.setTextSize(70);
        }
    }
//кнопка + / -
    public void modul(View view) {
        Double currentNumber = Double.parseDouble(editText.getText().toString());
        currentNumber*=-1;
        isDot = true;
        editText.setText(currentNumber.toString());
    }
//кнопка %
    public void CalculatePercent(View view) {
        if (arithmeticOperation.equals("")) {
            oldNumber = editText.getText().toString();
            Double Res = Double.parseDouble(oldNumber) / 100;
            isDot = true;
            editText.setText(Res.toString());
        }
        else{
            Double Result = 0.0;
            newNumber = editText.getText().toString();
            switch (arithmeticOperation){
                case "+":
                    Result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    isDot = true;
                    break;
                case "-":
                    Result =Double.parseDouble(oldNumber) * Double.parseDouble(newNumber)/100;
                    isDot = true;
                    break;
                case "*":
                    Result =Double.parseDouble(newNumber)/100;
                    isDot = true;
                    break;
                case "/":
                    Result = Double.parseDouble(newNumber)/100;
                    isDot = true;
                    break;
            }
            String curNumber = sizeFormat(Result.toString());
            editText.setText(curNumber);

        }

    }
// кнопка точка
    public void onTapDot(View view) {
        if (!isDot && !editText.getText().toString().contains(".")) {
            String currentNumber = editText.getText().toString();
            if (currentNumber.equals("0")) {
                currentNumber = "0.";
            } else {
                currentNumber += ".";
            }
            editText.setText(currentNumber);
            isDot = true;
        }
    }


    private String formatResult(String result, int maxLength) {
        String resultString = result;
        resultString = resultString.replaceAll("[.,]0*$", "");
        if (resultString.length() > maxLength) {
            resultString = resultString.substring(0, maxLength);
        }

        return resultString;
    }

    private String sizeFormat(String number){
        String newNumber = number;
        switch (newNumber.length()){
            case 6:
                editText.setTextSize(67);
                break;
            case 7:
                editText.setTextSize(65);
                break;
            case 8:
                editText.setTextSize(62);
                break;
            case 9:
                editText.setTextSize(59);
                break;
            case 10:
                editText.setTextSize(50);
                break;
        }
        return newNumber;
    }
}