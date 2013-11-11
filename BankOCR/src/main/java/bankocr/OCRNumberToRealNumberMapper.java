package bankocr;

import java.util.HashMap;
import java.util.Map;

class OCRNumberToRealNumberMapper {
    private static Map<String, String> ocrNumberToRealNumber = new HashMap<>();

    public static Map<String, String> getMapper() {
        ocrNumberToRealNumber.put(" _ " +
                                  "| |" +
                                  "|_|", "0");
        ocrNumberToRealNumber.put("   " +
                                  " | " +
                                  " | ", "1");
        ocrNumberToRealNumber.put(" _ " +
                                  " _|" +
                                  "|_ ", "2");
        ocrNumberToRealNumber.put(" _ " +
                                  " _|" +
                                  " _|", "3");
        ocrNumberToRealNumber.put("   " +
                                  "|_|" +
                                  "  |", "4");
        ocrNumberToRealNumber.put(" _ " +
                                  "|_ " +
                                  " _|", "5");

        return ocrNumberToRealNumber;
    }
}
