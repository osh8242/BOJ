import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final String HEADER = "Sun Mon Tue Wed Thr Fri Sat";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(HEADER);
        sb.append("\n");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int days = Integer.parseInt(st.nextToken());
        int idx = 1;
        sb.append("    ".repeat(start - 1));

        while (idx <= days) {
            sb.append(idx < 10 ? "  " : " ").append(idx++);
            sb.append(start++ % 7 == 0 ? "\n" : " ");
        }

        System.out.println(sb);
    }

}
