package com.example.testcalculator;

import android.util.Log;

public class Calculator {
    //輸入的整數部分
    private String intNumber;
    //輸入的小數部分
    private String decNumber;
    private Double totalNumber;
    private Double secondNum;
    //是否為正數
    private Boolean isPositive = true;
    //運算子 +_0 , -_1 , *_2 , /_3
    private int calOperator = 0;
    //動作 +_0 , -_1 , *_2 , /_3 , =_4 , ._5
    private int action = -1;
    private Boolean isDec;
    private Boolean isExponential = false;
    private Boolean isNan = false;
    private Boolean isKeyInNumber = false;


    public void init() {
        intNumber = "0";
        decNumber = "";
        totalNumber = 0.0;
        secondNum = 0.0;
        isPositive = true;
        calOperator = 0;
        action = -1;
        isDec = false;
        isExponential = false;
        isNan = false;
    }

    private void initCal() {
        intNumber = "0";
        decNumber = "";
        isPositive = true;
        isDec = false;
    }


    public String keyNumber(String keyNum) {
        if (action == Actions.EQUAL.ordinal()) {
            init();
        }
        if (secondNum != 0.0)
            secondNum = 0.0;
        try {
            if (!isExponential && !isNan) {
                if ((intNumber.length() + decNumber.length()) < 15) {
                    isKeyInNumber = true;
                    if (!isDec) {
                        if (intNumber.equals("0")) {
                            if (!keyNum.equals("0")) {
                                intNumber = keyNum;
                            }
                        } else {
                            intNumber += keyNum;
                        }
                        return intNumber;
                    } else {
                        decNumber += keyNum;
                        return intNumber + "." + decNumber;
                    }
                } else {
                    if (decNumber.equals("")) {
                        return intNumber;
                    } else {
                        return intNumber + "." + decNumber;
                    }
                }
            } else {
                if (isNan) {
                    return "錯誤!!";
                } else {
                    return totalNumber.toString();
                }
            }
        } catch (Exception e) {
            Log.e("keyNumberError", e.getLocalizedMessage());
            return "";
        }
    }

    public String numberBack() {
        if (intNumber.length() == 0 || decNumber.length() == 0) {
            return totalNumber.toString();
        } else {
            if (!isDec) {
                if (!intNumber.equals("0")) {
                    if (intNumber.length() == 1) {
                        intNumber = "0";
                    } else {
                        intNumber = intNumber.substring(0, intNumber.length()-1);
                    }
                }
                return intNumber;
            } else {
                if (decNumber.length() > 0) {
                    decNumber = decNumber.substring(0, decNumber.length()-1);
                } else {
                    isDec = false;
                    if (!intNumber.equals("0")) {
                        if (intNumber.length() == 1) {
                            intNumber = "0";
                        } else {
                            intNumber = intNumber.substring(0, intNumber.length()-1);
                        }
                    }
                }
                if (decNumber.length() > 0) {
                    return intNumber + "." + decNumber;
                } else {
                    return intNumber;
                }
            }
        }
    }

    public void clickOperator(Actions actions) {
        switch (actions) {
            case ADD:
            case MINUS:
            case MULTIPLICATION:
            case DIVISION:
                action = actions.ordinal();
                checkNum();
                calOperator = action;
                break;
            case EQUAL:
                checkNum();
                if (action == Actions.EQUAL.ordinal()) {
                    calculate();
                }
                action = actions.ordinal();
                break;
            case POINT:
                isDec = true;
                break;
        }
    }

    private void checkNum() {
        if ((!intNumber.equals("0") || !decNumber.equals("")) || isKeyInNumber) {
            secondNum = Double.parseDouble(intNumber + "." + decNumber);
            if (!isPositive) {
                secondNum = secondNum * (-1);
            }
            initCal();
            calculate();
        }
    }

    private void calculate() {
        Log.e("doCalculate", calOperator + ", " + totalNumber + " , " + secondNum);
        if (!isExponential && !isNan) {
            if (totalNumber == 0.0 && calOperator == 0) {
                totalNumber = secondNum;
            } else {
                switch (calOperator) {
                    case 0:
                        totalNumber = totalNumber + secondNum;
                        break;
                    case 1:
                        totalNumber = totalNumber - secondNum;
                        break;
                    case 2:
                        totalNumber = totalNumber * secondNum;
                        break;
                    case 3:
                        if (secondNum != 0) {
                            totalNumber = totalNumber / secondNum;
                        } else {
                            isNan = true;
                        }
                        break;
                }
            }
            Log.e("cal", totalNumber + "");
        }
        String text = totalNumber.toString();
        if (text.indexOf("E") > 0) {
            int idx = text.lastIndexOf("E");
            int check = Integer.parseInt(text.substring(idx + 1));
            if (check > 30) {
                isExponential = true;
            }
        }
        isKeyInNumber = false;
    }

    public void setIsDec() {
        isDec = true;
    }

    public Boolean getSign() {
        return isPositive;
    }

    public void setSign(Boolean sign) {
        isPositive = sign;
    }

    public Double getTotalNumber() {
        return totalNumber;
    }

    public Boolean getIsError() {
        return isExponential || isNan;
    }

    public Boolean getIsNan() {
        return isNan;
    }
}
