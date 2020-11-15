package com.example.testcalculator;

import android.util.Log;

import static com.example.testcalculator.Operator.*;

public class Calculator {
    //輸入的整數部分
    private String intNumber;
    //輸入的小數部分
    private String decNumber;
    private Number totalNumber;
    private Number secondNum;
    //是否為正數
    private Boolean isPositive = true;
    //運算子 +_0 , -_1 , *_2 , /_3 , =_4 , ._5
    private int calOperator = -1;
    private Boolean isDec;
    private Boolean isClickEqual = false;


    public void init() {
        intNumber = "";
        decNumber = "";
        totalNumber = 0;
        secondNum = 0;
        isPositive = true;
        calOperator = -1;
        isDec = false;
    }

    private void initCal(){
        intNumber = "";
        decNumber = "";
        secondNum = 0;
        isPositive = true;
        isDec = false;
    }


    public Number keyNumber(String keyNum) {
        if (!isDec) {
            intNumber += keyNum;
            return Integer.parseInt(intNumber);
        } else {
            decNumber += keyNum;
            return Double.parseDouble(intNumber + "." + decNumber);
        }
    }

    public void clickOperator(Operator operator) {
        switch (operator) {
            case ADD:
            case MINUS:
            case MULTIPLICATION:
            case DIVISION:
                calOperator = operator.ordinal();
                Log.e("operator num", calOperator + "");
                checkNum();
                break;
            case EQUAL:
                Log.e("Click Equal", "");
                checkNum();
                break;
            case POINT:
                isDec = true;
                break;
        }
    }

    private void checkNum() {
        if (!intNumber.equals("")
                && decNumber.equals("")) {
            secondNum = Integer.parseInt(intNumber);
            Log.e("checkNum_1", secondNum + "");
        } else if (!intNumber.equals("")
                || !decNumber.equals("")) {
            secondNum = Double.parseDouble("0." + decNumber);
            Log.e("checkNum_2", secondNum + "");
        }
        calculate();
    }

    private void calculate() {
        switch (calOperator) {
            case 0:
                totalNumber = (Double)totalNumber + (Double)secondNum ;
                break;
            case 1:
                totalNumber = (Double)totalNumber - (Double)secondNum ;
                break;
            case 2:
                totalNumber = (Double)totalNumber * (Double)secondNum ;
                break;
            case 3:
                totalNumber = (Double)totalNumber / (Double)secondNum ;
                break;
        }
        initCal();
    }

    public Boolean getIsDec() {
        return isDec;
    }

}
