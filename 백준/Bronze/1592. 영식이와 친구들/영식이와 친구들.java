import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] count = new int[N];
        int answer = 0;
        int ball = 0;
        count[ball]++;
        while (count[ball] < M) {
            ball = count[ball] % 2 != 0 ? (ball + L) % N :
                    (ball - L) >= 0 ? ball - L : ball - L + N;
            count[ball]++;
            answer++;
        }
        System.out.println(answer);
    }

}