package bankocr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class BankAccountsFormatterTest {
    private BankAccountsFormatter formatter = new BankAccountsFormatter(new BankOCRValidator());

    @Test
    public void formatBankAccounts_add_ERR_IfIncorrectChecksum() throws Exception {
        List<String> bankAccounts = new ArrayList<>(1);
        bankAccounts.add("111111110");

        assertThat(formatter.format(bankAccounts), contains("111111110 ERR"));
    }

    @Test
    public void formatBankAccounts_add_ILL_IfIncorrectBankAccount() throws Exception {
        List<String> bankAccounts = new ArrayList<>(1);
        bankAccounts.add("1111??110");

        assertThat(formatter.format(bankAccounts), contains("1111??110 ILL"));
    }

}
