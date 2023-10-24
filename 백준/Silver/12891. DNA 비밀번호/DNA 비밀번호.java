import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] dnaInput;
    static int[] dnaRef;
    static int dnaChecked = 0;
    static int answer = 0;
    static int S, P;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        dnaInput = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        dnaRef = new int[4];
        for (int i = 0; i < 4; i++) {
            dnaRef[i] = Integer.parseInt(st.nextToken());
            if (dnaRef[i] == 0) dnaChecked++;
        }
        for (int i = 0; i < P; i++) {
            add(dnaInput[i], i + 1);
        }
        for (int i = P; i < S; i++) {
            remove(dnaInput[i - P]);
            add(dnaInput[i], P);
        }
        System.out.println(answer);
    }

    static void add(char ch, int length) {
        switch (ch) {
            case 'A':
                dnaRef[0]--;
                break;
            case 'C':
                dnaRef[1]--;
                break;
            case 'G':
                dnaRef[2]--;
                break;
            case 'T':
                dnaRef[3]--;
                break;
        }
        if (validateDna() && P == length) answer++;
    }

    static void remove(char ch) {
        switch (ch) {
            case 'A':
                dnaRef[0]++;
                break;
            case 'C':
                dnaRef[1]++;
                break;
            case 'G':
                dnaRef[2]++;
                break;
            case 'T':
                dnaRef[3]++;
                break;
        }
    }

    static boolean validateDna() {
        if (dnaRef[0] <= 0 && dnaRef[1] <= 0 && dnaRef[2] <= 0 && dnaRef[3] <= 0) return true;
        else return false;
    }


}
