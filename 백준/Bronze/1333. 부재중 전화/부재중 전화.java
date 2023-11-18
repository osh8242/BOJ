import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int time = 0;
        while (true) {
            boolean isRinging = time % D == 0;
            boolean isPlaying = time % (L + 5) < L && time < N * (L + 5) - 5;
            if (isRinging && !isPlaying) break;
            time++;
        }

        System.out.println(time);
    }

}
