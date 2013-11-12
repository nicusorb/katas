package bankocr;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BankOCRValidatorTest {
    private BankOCRValidator bankOCRValidator = new BankOCRValidator();

    @Test
    public void onValidBankAccount_returnTrue() throws Exception {
        assertThat(bankOCRValidator.isValidChecksum("000000000"), is(true));
        assertThat(bankOCRValidator.isValidChecksum("011111111"), is(true));
    }

    @Test
    public void onInvalidBankAccount_returnFalse() throws Exception {
        assertThat(bankOCRValidator.isValidChecksum("111111111"), is(true));
    }
}
