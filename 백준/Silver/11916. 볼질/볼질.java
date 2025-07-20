import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean first = false, second = false, third = false;
        int balls = 0, runs = 0;
        for (int i = 0; i < N; i++) {
            int pitch = Integer.parseInt(st.nextToken());
            if (pitch == 3) {  // 폭투
                if (third) { runs++; third = false; }
                if (second) { third = true; second = false; }
                if (first)  { second = true; first = false; }
                balls++;
                if (balls == 4) {
                    // 볼넷 처리
                    balls = 0;
                    boolean f = first, s = second, t = third;
                    if (t && f && s) { runs++; t = false; }
                    if (s && f)      { t = true; s = false; }
                    if (f)           { s = true; f = false; }
                    first = true; second = s; third = t;
                }
            } else if (pitch == 1) {  // 볼
                balls++;
                if (balls == 4) {
                    balls = 0;
                    boolean f = first, s = second, t = third;
                    if (t && f && s) { runs++; t = false; }
                    if (s && f)      { t = true; s = false; }
                    if (f)           { s = true; f = false; }
                    first = true; second = s; third = t;
                }
            } else {  // 몸에 맞는 공
                balls = 0;
                boolean f = first, s = second, t = third;
                if (t && f && s) { runs++; t = false; }
                if (s && f)      { t = true; s = false; }
                if (f)           { s = true; f = false; }
                first = true; second = s; third = t;
            }
        }
        System.out.println(runs);
    }
}
