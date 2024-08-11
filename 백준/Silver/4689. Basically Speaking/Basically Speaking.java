import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            String numsString = st.nextToken();
            int fromBase = Integer.parseInt(st.nextToken());
            int toBase = Integer.parseInt(st.nextToken());
            String toBaseString = getToBaseStringFromNumString(numsString, fromBase, toBase);
            sb.append(String.format("%7s", isError(toBaseString) ? "ERROR" : toBaseString)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static String getToBaseStringFromNumString(String numString, int fromBase, int toBase) {
        String decimalString = getDecimalString(numString, fromBase);
        if (toBase == 10) return decimalString;
        return getToBaseStringFromDecimalString(decimalString, toBase);
    }

    static String getToBaseStringFromDecimalString(String decimalString, int toBase) {
        StringBuilder answer = new StringBuilder();
        int numValue = Integer.parseInt(decimalString);
        while (numValue > 0) {
            int digitValue = numValue % toBase;
            answer.insert(0, getDigit(digitValue));
            numValue = numValue / toBase;
        }
        return answer.toString();
    }

    static String getDecimalString(String numString, int fromBase) {
        int result = 0;
        int factor = 1;
        for (int i = numString.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(numString.charAt(i));
            result += factor * digit;
            factor *= fromBase;
        }
        return Integer.toString(result);
    }

    static char getDigit(int digitValue) {
        return digitValue >= 10 ? (char) ('A' + digitValue - 10) : (char) ('0' + digitValue);
    }

    static boolean isError(String numString) {
        return numString.length() > 7;
    }
}
