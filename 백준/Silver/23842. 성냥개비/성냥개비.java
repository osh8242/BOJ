import java.io.*;

public class Main {

    private static final int[] MATCHES = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    private static final String IMPOSSIBLE = "impossible";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int givenMatches = N - 4;
        bw.write(getAnswer(givenMatches));

        bw.flush();
    }

    static String getAnswer(int givenMatches) {
        if (givenMatches < 18) return IMPOSSIBLE;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                int k = i + j;
                if (k > 99) break;
                if (isCorrectEquation(i, j, k, givenMatches)) {
                    return String.format("%02d+%02d=%02d", i, j, k);
                }
            }
        }
        return IMPOSSIBLE;
    }

    static boolean isCorrectEquation(int i, int j, int k, int givenMatches) {
        return getRequiredMatches(i) + getRequiredMatches(j) + getRequiredMatches(k) == givenMatches;
    }

    static int getRequiredMatches(int i) {
        return MATCHES[i / 10] + MATCHES[i % 10];
    }

}
