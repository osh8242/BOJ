import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNum = 1;
        while (true) {
            String line = br.readLine();
            if (line == null) break; 
            int n = Integer.parseInt(line.trim());
            if (n == 0) break; 

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (i == 1 || i == n) {
                    while (st.hasMoreTokens()) {
                        sum += Integer.parseInt(st.nextToken());
                    }
                } else {
                    int first = Integer.parseInt(st.nextToken());
                    int last = first;
                    for (int j = 2; j <= i; j++) {
                        last = Integer.parseInt(st.nextToken());
                    }
                    sum += first + last;
                }
            }

            sb.append("Case #").append(caseNum++).append(":").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
