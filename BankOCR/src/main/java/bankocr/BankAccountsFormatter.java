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
            if (!validator.isValidChecksum(bankAccount)) {
                formattedBankAccounts.add(bankAccount + " ERR");
            } else if (!validator.isValidBankAccount(bankAccount)) {
                formattedBankAccounts.add(bankAccount);
            }
        }

        return formattedBankAccounts;
    }
}