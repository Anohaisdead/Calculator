package Calculator.arithmetic;

import java.util.Arrays;
import java.util.List;

class Calc {
    int num1, num2;
    String operator;
    int calcExp(int n1, String op, int n2){
        int res;
        switch (op) {
            case "+":
                res = n1+n2;
                break;
            case "-":
                res = n1-n2;
                break;
            case "*":
                res = n1*n2;
                break;
            case "/":
                res = n1/n2;
                break;
            default:
                throw new AssertionError();
        }
        return res;
    }
    String result(String exp) throws CalculatorException{
        boolean isRomanExp;
        Convert convert = new Convert();
        List<String> expItems = Arrays.asList(exp.split(" "));

        if (expItems.size()!=3){
            throw new CalculatorException("неверно задано выражение");
        }
        if (convert.checkOperator(expItems.get(1))){
            operator = expItems.get(1);
        } else {
            throw new CalculatorException("неверный оператор");
        }
        if (convert.isNumeric(expItems.get(0)) && convert.isNumeric(expItems.get(2))){
            num1 = Integer.parseInt(expItems.get(0));
            num2 = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (convert.isRoman(expItems.get(0)) && convert.isRoman(expItems.get(2))){
            num1 = convert.romeToArabConvert(expItems.get(0));
            num2 = convert.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        } else {
            throw new CalculatorException("неверно задано выражение");
        }
        if (!(num1>=1 && num1<=10)){
            throw new CalculatorException("неверные числа в выражении");
        }

        if (!(num2>=1 && num2<=10)){
            throw new CalculatorException("неверные числа в выражении");
        }
        int res = calcExp(num1, operator, num2);
        if (isRomanExp && (res<=0)){
            throw new CalculatorException("римские числа не имеют отрицательных значений и нуля");
        }
        if (isRomanExp){
            String sign = res < 0 ? "-" : "";
            return sign + convert.arabToRomeConvert(Math.abs(res));
        }

        return String.valueOf(res);
    }

}