import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 1;
            int current = Integer.parseInt(st.nextToken());
            for (int i = 1; i < N; i++) {
                int next = Integer.parseInt(st.nextToken());
                if (next > current) count++;
                else {
                    list.add(count);
                    count = 1;
                }
                current = next;
            }
            list.add(count);

            long answer = 0;
            for (Integer i : list) {
                answer += (long) i * (i + 1) / 2;
            }

            bw.write(String.valueOf(answer));
            bw.flush();
        }
    }

}
