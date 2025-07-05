import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (P-- > 0) {
            String[] sp = br.readLine().split(" ");
            String K = sp[0];
            int[] a = new int[15];
            int mx = 0;
            for (int i = 0; i < 15; i++) {
                a[i] = Integer.parseInt(sp[i + 1]);
                if (a[i] > mx) mx = a[i];
            }
            int islands = 0;
            // 각 레벨 h=1..mx에서 a[i]>=h인 구간의 개수를 센다
            for (int h = 1; h <= mx; h++) {
                boolean inBlock = false;
                for (int i = 0; i < 15; i++) {
                    if (a[i] >= h) {
                        if (!inBlock) {
                            islands++;
                            inBlock = true;
                        }
                    } else {
                        inBlock = false;
                    }
                }
            }
            sb.append(K).append(' ').append(islands).append('\n');
        }
        System.out.print(sb);
    }
}
