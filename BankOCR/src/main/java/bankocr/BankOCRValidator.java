package bankocr;

public class BankOCRValidator {
    public boolean isValidChecksum(String bankAccount) {
        int checkSum = 0;
        for (int i = bankAccount.length() - 1; i > 0; i--) {
            checkSum += Integer.parseInt(bankAccount.charAt(i) + "") * (i + 1);
        }
        return checkSum % 11 == 0;
    }

    public boolean isValidBankAccount(String bankAccount) {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }
}