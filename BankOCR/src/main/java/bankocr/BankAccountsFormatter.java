package bankocr;

import java.util.ArrayList;
import java.util.List;

public class BankAccountsFormatter {
    private BankOCRValidator validator;

    public BankAccountsFormatter(BankOCRValidator validator) {
        this.validator = validator;
    }

    public List<String> format(List<String> bankAccounts) {
        List<String> formattedBankAccounts = new ArrayList<>();

        for (String bankAccount : bankAccounts) {
            String err = "";
            if (!validator.isValidBankAccount(bankAccount)) {
                err = " ILL";
            } else if (!validator.isValidChecksum(bankAccount)) {
                err = " ERR";
            }
            formattedBankAccounts.add(bankAccount + err);
        }

        return formattedBankAccounts;
    }
}