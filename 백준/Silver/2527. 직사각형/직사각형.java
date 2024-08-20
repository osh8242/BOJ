import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int p1 = Integer.parseInt(input[2]);
            int q1 = Integer.parseInt(input[3]);
            int x2 = Integer.parseInt(input[4]);
            int y2 = Integer.parseInt(input[5]);
            int p2 = Integer.parseInt(input[6]);
            int q2 = Integer.parseInt(input[7]);

            // 공통 부분이 없는 경우
            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                sb.append("d\n");
            }
            // 공통 부분이 점인 경우
            else if ((p1 == x2 && q1 == y2) || (x1 == p2 && q1 == y2) ||
                    (p1 == x2 && y1 == q2) || (x1 == p2 && y1 == q2)) {
                sb.append("c\n");
            }
            // 공통 부분이 선분인 경우
            else if (p1 == x2 || x1 == p2 || q1 == y2 || y1 == q2) {
                sb.append("b\n");
            }
            // 공통 부분이 직사각형인 경우
            else {
                sb.append("a\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
