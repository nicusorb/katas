package bankocr;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

public class BankOCRTest {
    private BankOCR bankOCR = new BankOCR();

    @Test
    public void recognizeOnlyNumberOne() throws Exception {
        List<String> bankAccount = bankOCR.obtainBankAccounts("../onlyOne.txt");

        assertThat(bankAccount, contains("1"));
    }

    @Test
    public void recognizeOnlyNumberTwo() throws Exception {
        List<String> bankAccount = bankOCR.obtainBankAccounts("../onlyTwo.txt");

        assertThat(bankAccount, contains("2"));
    }

    @Test
    public void recognizeTwoOnes() throws Exception {
        List<String> bankAccount = bankOCR.obtainBankAccounts("../twoOnes.txt");

        assertThat(bankAccount, contains("11"));
    }

    @Test
    public void recognizeThreeOnes() throws Exception {
        List<String> bankAccount = bankOCR.obtainBankAccounts("../threeOnes.txt");

        assertThat(bankAccount, contains("111"));
    }

    @Test
    public void recognizeNumbersFromOneRow() throws Exception {
        List<String> bankAccount = bankOCR.obtainBankAccounts("../oneRow.txt");

        assertThat(bankAccount, contains("123451234"));
    }

    @Test
    public void recognizeNumbersFromMultipleRows() throws Exception {
        List<String> bankAccounts = bankOCR.obtainBankAccounts("../multipleRows.txt");

        assertThat(bankAccounts, contains("123451234", "000000000"));
    }

    @Test
    public void onValidBankAccount_returnTrue() throws Exception {
        assertThat(bankOCR.isValid("000000000"), is(true));
        assertThat(bankOCR.isValid("011111111"), is(true));
    }

    @Test
    public void onInvalidBankAccount_returnFalse() throws Exception {
        assertThat(bankOCR.isValid("111111111"), is(true));
    }
}
