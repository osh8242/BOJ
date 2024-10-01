import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] rowCount = new int[9];
            while (N-- > 0) {
                st.nextToken();
                int row = Integer.parseInt(st.nextToken());
                rowCount[row]++;
            }
            int max = 0;
            for (int count : rowCount) max = Math.max(max, count);
            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
