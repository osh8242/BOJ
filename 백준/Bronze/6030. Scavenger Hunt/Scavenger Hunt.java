import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int P = Integer.parseInt(parts[0]);
        int Q = Integer.parseInt(parts[1]);

        ArrayList<Integer> fp = new ArrayList<>();
        for (int i = 1; i * i <= P; i++) {
            if (P % i == 0) {
                fp.add(i);
                if (i * i != P) {
                    fp.add(P / i);
                }
            }
        }
        Collections.sort(fp);

        ArrayList<Integer> fq = new ArrayList<>();
        for (int i = 1; i * i <= Q; i++) {
            if (Q % i == 0) {
                fq.add(i);
                if (i * i != Q) {
                    fq.add(Q / i);
                }
            }
        }
        Collections.sort(fq);

        StringBuilder sb = new StringBuilder();
        for (int x : fp) {
            for (int y : fq) {
                sb.append(x).append(' ').append(y).append('\n');
            }
        }
        System.out.print(sb.toString());
    }
}
