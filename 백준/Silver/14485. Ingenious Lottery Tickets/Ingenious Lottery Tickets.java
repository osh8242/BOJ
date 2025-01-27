import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] freq = new int[50];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 6; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    freq[num]++;
                }
            }

            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= 49; i++) {
                numbers.add(i);
            }

            numbers.sort((a, b) -> {
                if (freq[b] != freq[a]) {
                    return Integer.compare(freq[b], freq[a]);
                } else {
                    if (a == 7 || b == 7) {
                        if (a == 7) return -1;
                        else return 1;
                    } else {
                        return a.compareTo(b);
                    }
                }
            });

            List<Integer> selected = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                selected.add(numbers.get(i));
            }
            Collections.sort(selected);

            for (int i = 0; i < 6; i++) {
                sb.append(selected.get(i));
                if (i < 5) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}