import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int b = 1; b <= 500; b++) {
            for (int a = 1; ; a++) {
                if (b * b + N == a * a) {
                    answer++;
                    break;
                } else if (b * b + N < a * a) {
                    break;
                }
            }
        }
        System.out.println(answer);
    }

}
