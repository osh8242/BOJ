import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        for (int round = 0; round < N; round++) {
            int[] cntA = new int[5];
            int[] cntB = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int i = 0; i < a; i++) {
                cntA[Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int i = 0; i < b; i++) {
                cntB[Integer.parseInt(st.nextToken())]++;
            }
            char res = 'D';
            for (int shape = 4; shape >= 1; shape--) {
                if (cntA[shape] > cntB[shape]) {
                    res = 'A';
                    break;
                } else if (cntA[shape] < cntB[shape]) {
                    res = 'B';
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
