import java.awt.Point;

public class Playfair {
    private static char[][] charTable;
    private static Point[] positions;

    public static String prepareText(String input, boolean forKey) {
        input = input.toUpperCase().replaceAll("[^A-Z]", "");
        return forKey ? input.replaceAll("J", "I") : input;
    }

    public static void createTable(String key) {
        charTable = new char[5][5];
        positions = new Point[26];

        String keyAlphabet = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        for (int i = 0, k = 0; i < keyAlphabet.length(); i++) {
            char c = keyAlphabet.charAt(i);
            if (positions[c - 'A'] == null) {
                charTable[k / 5][k % 5] = c;
                positions[c - 'A'] = new Point(k % 5, k / 5);
                k++;
            }
        }
    }

    public static String encode(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            if (i + 1 == text.length() || text.charAt(i) == text.charAt(i + 1)) {
                text = text.substring(0, i + 1) + 'X' + text.substring(i + 1);
            }
            result.append(encodePair(text.charAt(i), text.charAt(i + 1)));
        }
        return result.toString();
    }

    public static String decode(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            result.append(decodePair(text.charAt(i), text.charAt(i + 1)));
        }
        return result.toString();
    }

    public static String encodePair(char a, char b) {
        StringBuilder result = new StringBuilder();
        int row1 = positions[a - 'A'].y;
        int row2 = positions[b - 'A'].y;
        int col1 = positions[a - 'A'].x;
        int col2 = positions[b - 'A'].x;

        if (row1 == row2) {
            result.append(charTable[row1][(col1 + 1) % 5]);
            result.append(charTable[row2][(col2 + 1) % 5]);
        } else if (col1 == col2) {
            result.append(charTable[(row1 + 1) % 5][col1]);
            result.append(charTable[(row2 + 1) % 5][col2]);
        } else {
            result.append(charTable[row1][col2]);
            result.append(charTable[row2][col1]);
        }

        return result.toString();
    }

    public static String decodePair(char a, char b) {
        StringBuilder result = new StringBuilder();
        int row1 = positions[a - 'A'].y;
        int row2 = positions[b - 'A'].y;
        int col1 = positions[a - 'A'].x;
        int col2 = positions[b - 'A'].x;

        if (row1 == row2) {
            result.append(charTable[row1][(col1 + 4) % 5]);
            result.append(charTable[row2][(col2 + 4) % 5]);
        } else if (col1 == col2) {
            result.append(charTable[(row1 + 4) % 5][col1]);
            result.append(charTable[(row2 + 4) % 5][col2]);
        } else {
            result.append(charTable[row1][col2]);
            result.append(charTable[row2][col1]);
        }

        return result.toString();
    }
}
