package roman;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RomanToArabicConverterTest {
    private RomanToArabicConverter converter = new RomanToArabicConverter();

    private void shouldConvertRomanNumeralToArabic(String romanNumber, int number) {
        assertThat(converter.convert(romanNumber), is(number));
        assertThat(converter.convertNonRecursive(romanNumber), is(number));
    }

    @Test
    public void convertsRomanNumerals_to_arabicNumbers() throws Exception {
        shouldConvertRomanNumeralToArabic("I", 1);
        shouldConvertRomanNumeralToArabic("II", 2);
        shouldConvertRomanNumeralToArabic("III", 3);
        shouldConvertRomanNumeralToArabic("IV", 4);
        shouldConvertRomanNumeralToArabic("V", 5);
        shouldConvertRomanNumeralToArabic("VI", 6);
        shouldConvertRomanNumeralToArabic("VIII", 8);
        shouldConvertRomanNumeralToArabic("IX", 9);
        shouldConvertRomanNumeralToArabic("X", 10);
        shouldConvertRomanNumeralToArabic("XIX", 19);
        shouldConvertRomanNumeralToArabic("MCMXC", 1990);
        shouldConvertRomanNumeralToArabic("MMVIII", 2008);
    }
}
