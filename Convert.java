package Calculator.arithmetic;

import java.util.HashMap;
import java.util.Map;

class Convert {
    final Map<String, Integer> romeArabMap = new HashMap<>();

    final int[] arabDigit = new int[]{10, 9, 5, 4, 1};
    final String[] romeDigit = new String[]{"X", "IX", "V", "IV", "I"};

    Convert() {
        romeArabMap.put("I", 1);
        romeArabMap.put("II", 2);
        romeArabMap.put("III", 3);
        romeArabMap.put("IV", 4);
        romeArabMap.put("V", 5);
        romeArabMap.put("VI", 6);
        romeArabMap.put("VII", 7);
        romeArabMap.put("VIII", 8);
        romeArabMap.put("IX", 9);
        romeArabMap.put("X", 10);
    }

    boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    boolean isRoman(String str) {
        return romeArabMap.containsKey(str);
    }

    Integer romeToArabConvert(String st){
        if (romeArabMap.containsKey(st)){
            return romeArabMap.get(st);
        }
        return null;
    }

    String arabToRomeConvert(Integer num){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i<arabDigit.length; i++){
            while((num - arabDigit[i])>=0){
                num -= arabDigit[i];
                result.append(romeDigit[i]);
            }
        }
        return result.toString();
    }

    boolean checkOperator(String op){
        return "*".equals(op) || "/".equals(op) || "+".equals(op) || "-".equals(op);
    }

}