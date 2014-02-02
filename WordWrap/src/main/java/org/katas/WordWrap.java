package org.katas;

public class WordWrap {
    public static String wrap(String s, int columnLength) {
        if (lineFitsTheColumnLength(s, columnLength))
            return s;

        int lastIndexOfSpace = s.substring(0, columnLength).lastIndexOf(' ');
        if (lastIndexOfSpace != -1) {
            String firstLine = s.substring(0, lastIndexOfSpace);
            return firstLine + "\n" + wrap(s.substring(lastIndexOfSpace + 1), columnLength);
        } else {
            int firstIndexOfSpace = s.substring(columnLength).indexOf(' ');
            if (firstIndexOfSpace != -1) {
                return s.substring(0, columnLength + firstIndexOfSpace) + '\n' +
                        wrap(s.substring(columnLength + firstIndexOfSpace + 1), columnLength);
            }
            return s;
        }
    }

    private static boolean lineFitsTheColumnLength(String s, int columnLength) {
        return s.length() <= columnLength;
    }
}
