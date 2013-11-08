package roman;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ArabicToRomanNumeralsConverter {
    private Map<Integer, String> arabicToRoman = new LinkedHashMap<>();

    public ArabicToRomanNumeralsConverter() {
        arabicToRoman.put(1000, "M");
        arabicToRoman.put(900, "CM");
        arabicToRoman.put(500, "D");
        arabicToRoman.put(400, "CD");
        arabicToRoman.put(100, "C");
        arabicToRoman.put(90, "XC");
        arabicToRoman.put(50, "L");
        arabicToRoman.put(40, "XL");
        arabicToRoman.put(10, "X");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(1, "I");
    }

    public String convert(int number) {
        Set<Integer> numbers = arabicToRoman.keySet();

        for (int n : numbers) {
            if (number >= n) {
                return arabicToRoman.get(n) + convert(number - n);
            }
        }

        return "";
    }

    public String convertNonRecursive(int number) {
        String roman = "";
        Set<Integer> numbers = arabicToRoman.keySet();

        for (int n : numbers) {
            while (number >= n) {
                roman += arabicToRoman.get(n);
                number -= n;
            }
        }

        return roman;
    }
}
