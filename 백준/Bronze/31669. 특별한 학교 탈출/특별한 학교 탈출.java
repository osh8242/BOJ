import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);

        String[] schedule = new String[N];
        for (int i = 0; i < N; i++) {
            schedule[i] = br.readLine();
        }

        int escapeTime = -1;
        for (int t = 0; t < M; t++) {
            boolean anyOnPatrol = false;
            for (int i = 0; i < N; i++) {
                if (schedule[i].charAt(t) == 'O') {
                    anyOnPatrol = true;
                    break;
                }
            }
            if (!anyOnPatrol) {
                escapeTime = t + 1;  // 1-indexed
                break;
            }
        }

        if (escapeTime == -1) {
            System.out.println("ESCAPE FAILED");
        } else {
            System.out.println(escapeTime);
        }
    }
}
