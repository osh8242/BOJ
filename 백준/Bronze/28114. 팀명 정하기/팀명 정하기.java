import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] P = new int[3];
        int[] Y = new int[3];
        String[] S = new String[3];
        for (int i = 0; i < 3; i++) {
            String[] parts = br.readLine().split(" ");
            P[i] = Integer.parseInt(parts[0]);
            Y[i] = Integer.parseInt(parts[1]);
            S[i] = parts[2];
        }
        int[] rem = new int[3];
        for (int i = 0; i < 3; i++) rem[i] = Y[i] % 100;
        Arrays.sort(rem);
        StringBuilder sb1 = new StringBuilder();
        for (int v : rem) sb1.append(v);
        Integer[] idx = {0, 1, 2};
        Arrays.sort(idx, (a, b) -> Integer.compare(P[b], P[a]));
        StringBuilder sb2 = new StringBuilder();
        for (int i : idx) sb2.append(S[i].charAt(0));
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
    }
}
