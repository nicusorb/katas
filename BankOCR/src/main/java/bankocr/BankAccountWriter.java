package bankocr;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class BankAccountWriter {
    public void write(List<String> bankAccounts, File outputFile) throws Exception {
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputFile.toURI()),
                Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        for (String bankAccount : bankAccounts) {
            bufferedWriter.write(bankAccount);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
