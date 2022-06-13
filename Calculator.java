package Calculator.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Calculator {

    public static void main(String[] args) throws IOException, CalculatorException {
        System.out.print("Input: ");
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String calcString = bReader.readLine();
        Calc calc = new Calc();
        String result = calc.result(calcString);
        System.out.println(result);

    }

}