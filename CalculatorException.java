package Calculator.arithmetic;

class CalculatorException extends Exception {
    CalculatorException() {
        System.out.println("throws Exception");
    }

        CalculatorException(String message){
        this();
        System.out.println(message);
    }
}