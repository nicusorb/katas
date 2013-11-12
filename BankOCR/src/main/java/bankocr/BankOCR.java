package bankocr;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.readAllLines;

public class BankOCR {
    private Map<String, String> ocrNumberToRealNumber = new HashMap<>();

    public BankOCR() {
        ocrNumberToRealNumber = OCRNumberToRealNumberMapper.getMapper();
    }

    public List<String> obtainBankAccounts(String fileName) throws Exception {
        List<String> lines = readAllLinesFromFile(fileName);
        List<String> bankAccounts = new ArrayList<>();

        while (!lines.isEmpty()) {
            bankAccounts.add(obtainBankAccount(lines));
        }
        return bankAccounts;
    }

    private String obtainBankAccount(List<String> lines) {
        String firstLine = lines.remove(0);
        String secondLine = lines.remove(0);
        String thirdLine = lines.remove(0);
        removeNextEmptyLineIfPresent(lines);

        String bankAccount = "";
        while (!firstLine.isEmpty()) {
            String ocrNumber = obtainFirstNumberRepresentation(firstLine, secondLine, thirdLine);

            bankAccount += ocrNumberToRealNumber.get(ocrNumber);

            firstLine = firstLine.substring(3);
            secondLine = secondLine.substring(3);
            thirdLine = thirdLine.substring(3);
        }
        return bankAccount;
    }

    private void removeNextEmptyLineIfPresent(List<String> lines) {
        if (!lines.isEmpty() && lines.get(0).equals(""))
            lines.remove(0);
    }

    private String obtainFirstNumberRepresentation(String firstLine, String secondLine, String thirdLine) {
        return firstLine.substring(0, 3) + secondLine.substring(0, 3) + thirdLine.substring(0, 3);
    }

    private List<String> readAllLinesFromFile(String fileName) throws Exception {
        URL fileURI = getClass().getResource(fileName);
        return readAllLines(Paths.get(fileURI.toURI()), Charset.forName("UTF-8"));
    }
}
