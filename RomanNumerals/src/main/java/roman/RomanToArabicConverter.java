package roman;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToArabicConverter {
    private Map<String, Integer> romanToArabic = new LinkedHashMap<>();

    public RomanToArabicConverter() {
        romanToArabic.put("M", 1000);
        romanToArabic.put("CM", 900);
        romanToArabic.put("D", 500);
        romanToArabic.put("LD", 400);
        romanToArabic.put("C", 100);
        romanToArabic.put("XC", 90);
        romanToArabic.put("L", 50);
        romanToArabic.put("XL", 40);
        romanToArabic.put("X", 10);
        romanToArabic.put("IX", 9);
        romanToArabic.put("V", 5);
        romanToArabic.put("IV", 4);
        romanToArabic.put("I", 1);
    }

    public int convert(String romanNumeral) {
        for (String romanNumber : romanToArabic.keySet()) {
            if (romanNumeral.startsWith(romanNumber)) {
                return romanToArabic.get(romanNumber) + convert(romanNumeral.substring(romanNumber.length()));
            }
        }

        return 0;
    }

    public int convertNonRecursive(String romanNumeral) {
        int arabicNumber = 0;
        for (String romanNumber : romanToArabic.keySet()) {
            while (romanNumeral.startsWith(romanNumber)) {
                arabicNumber += romanToArabic.get(romanNumber);
                romanNumeral = romanNumeral.substring(romanNumber.length());
            }
        }

        return arabicNumber;
    }
}
