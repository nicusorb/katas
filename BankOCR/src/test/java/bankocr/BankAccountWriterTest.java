package bankocr;

import org.junit.Test;

import java.io.File;
import java.util.List;

public class BankAccountWriterTest {
    @Test
    public void writeBankAccountsToAFile() throws Exception {
        BankOCR bankOCR = new BankOCR();
        BankAccountWriter writer = new BankAccountWriter();

        List<String> bankAccounts = bankOCR.obtainBankAccounts("../multipleRows.txt");

        writer.write(bankAccounts, new File("multipleRowsOutput.txt"));
    }

    @Test
    public void writeBankAccountsError_ifChecksumIsIncorrect() throws Exception {
        BankOCR bankOCR = new BankOCR();
        BankAccountWriter writer = new BankAccountWriter();
        BankAccountsFormatter formatter = new BankAccountsFormatter(new BankOCRValidator());

        List<String> bankAccounts = bankOCR.obtainBankAccounts("../multipleRows.txt");

        writer.write(formatter.format(bankAccounts), new File("multipleRowsWithChecksumErrorOutput.txt"));
    }
}
