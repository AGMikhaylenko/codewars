package kyu6;

/**
 * The Hamming Code is used to correct errors, so-called bit flips, in data transmissions.
 * Later in the description follows a detailed explanation of how it works.
 * In this Kata we will implement the Hamming Code with bit length 3; this has some advantages and disadvantages:
 */
public class HammingCode {

    public static void main(String[] args) {
        HammingCode hc = new HammingCode();
        hc.decode(hc.encode("hey"));
    }

    public String encode(String text) {
        String bits = "";
        byte[] ascii = text.getBytes();

        for (byte b : ascii) {
            bits += String.format("%08d", Integer.parseInt(Integer.toBinaryString(b)));
        }

        char[] symbols = bits.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < symbols.length; i++)
            sb.append(symbols[i]).append(symbols[i]).append(symbols[i]);

        return sb.toString();
    }

    public String decode(String bits) {
        char[] symbols = bits.toCharArray();
        StringBuilder bytes = new StringBuilder();
        for (int i = 0; i < symbols.length / 3; i++)
            bytes.append(getCorrectChar(new char[]{symbols[3 * i], symbols[3 * i + 1], symbols[3 * i + 2]}));
        symbols = bytes.toString().toCharArray();
        bytes = new StringBuilder();
        for (int i = 0; i < symbols.length / 8; i++) {
            bytes.append(getFinalChar(new StringBuilder().append(symbols[8 * i]).append(symbols[8 * i + 1]).
                    append(symbols[8 * i + 2]).append(symbols[8 * i + 3]).append(symbols[8 * i + 4]).
                    append(symbols[8 * i + 5]).append(symbols[8 * i + 6]).append(symbols[8 * i + 7]).toString()));
        }
        return bytes.toString();
    }

    private char getCorrectChar(char[] s) {
        int countOne = 0;
        int countZero = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '1') {
                countOne++;
            } else {
                countZero++;
            }
        }
        return countOne > countZero ? '1' : '0';
    }

    private char getFinalChar(String s) {
        int i = Integer.parseInt(s, 2);
        return (char)i;
    }

}
