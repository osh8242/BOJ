import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dnaRef;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String dnaString = br.readLine();
        st = new StringTokenizer(br.readLine());
        dnaRef = new int[4];
        for (int i = 0; i < 4; i++) dnaRef[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < dnaString.length() - P + 1; i++) {
            if (validatePassword(dnaString.substring(i, i + P))) count++;
        }
        System.out.println(count);
    }

    static boolean validatePassword(String pString) {
        int[] dnaCount = dnaRef.clone();
        for (int i = 0; i < pString.length(); i++) {
            switch (pString.charAt(i)) {
                case 'A':
                    dnaCount[0]--;
                    break;
                case 'C':
                    dnaCount[1]--;
                    break;
                case 'G':
                    dnaCount[2]--;
                    break;
                case 'T':
                    dnaCount[3]--;
                    break;
            }
            if (dnaCount[0] <= 0 && dnaCount[1] <= 0 && dnaCount[2] <= 0 && dnaCount[3] <= 0) return true;
        }
        return false;
    }

}
