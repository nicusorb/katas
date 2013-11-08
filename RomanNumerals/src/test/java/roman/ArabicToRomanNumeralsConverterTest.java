package roman;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ArabicToRomanNumeralsConverterTest {
    private ArabicToRomanNumeralsConverter converter = new ArabicToRomanNumeralsConverter();

    @Test
    public void convertsArabicNumbers() throws Exception {
        arabicNumberConvertsToRomanNumber(1, "I");
        arabicNumberConvertsToRomanNumber(2, "II");
        arabicNumberConvertsToRomanNumber(3, "III");
        arabicNumberConvertsToRomanNumber(4, "IV");
        arabicNumberConvertsToRomanNumber(5, "V");
        arabicNumberConvertsToRomanNumber(6, "VI");
        arabicNumberConvertsToRomanNumber(7, "VII");
        arabicNumberConvertsToRomanNumber(9, "IX");
        arabicNumberConvertsToRomanNumber(10, "X");
        arabicNumberConvertsToRomanNumber(11, "XI");
        arabicNumberConvertsToRomanNumber(14, "XIV");
        arabicNumberConvertsToRomanNumber(19, "XIX");
        arabicNumberConvertsToRomanNumber(20, "XX");
        arabicNumberConvertsToRomanNumber(24, "XXIV");
        arabicNumberConvertsToRomanNumber(39, "XXXIX");
        arabicNumberConvertsToRomanNumber(40, "XL");
        arabicNumberConvertsToRomanNumber(41, "XLI");
        arabicNumberConvertsToRomanNumber(49, "XLIX");
        arabicNumberConvertsToRomanNumber(50, "L");
        arabicNumberConvertsToRomanNumber(51, "LI");
        arabicNumberConvertsToRomanNumber(59, "LIX");
        arabicNumberConvertsToRomanNumber(89, "LXXXIX");
        arabicNumberConvertsToRomanNumber(90, "XC");
        arabicNumberConvertsToRomanNumber(99, "XCIX");
        arabicNumberConvertsToRomanNumber(100, "C");
        arabicNumberConvertsToRomanNumber(149, "CXLIX");
        arabicNumberConvertsToRomanNumber(1990, "MCMXC");
        arabicNumberConvertsToRomanNumber(2008, "MMVIII");
    }

    private void arabicNumberConvertsToRomanNumber(int number, String romanNumber) {
        assertThat(converter.convert(number), is(romanNumber));
        assertThat(converter.convertNonRecursive(number), is(romanNumber));
    }
}
