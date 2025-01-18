import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int maxCount = 1;
    static int count = 0;
    static char prev = 'V';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] beads = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            if (beads[i] == 'V' || prev == 'V' || beads[i] == prev) {
                prev = beads[i];
                maxCount = Math.max(maxCount, count);
                count = 1;
            } else if (beads[i] != prev) {
                prev = beads[i];
                count++;
            }
        }
        maxCount = Math.max(maxCount, count);
        System.out.println(maxCount);
    }
}
