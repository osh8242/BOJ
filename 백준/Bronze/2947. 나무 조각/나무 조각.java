import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    for (int k = 0; k < 5; k++) {
                        sb.append(a[k]);
                        if (k < 4) sb.append(' ');
                    }
                    sb.append('\n');
                }
            }
            boolean sorted = true;
            for (int i = 0; i < 4; i++) {
                if (a[i] > a[i + 1]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;
        }

        System.out.print(sb.toString());
    }
}
