import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int maxLength = 0;
            int length = 0;
            for (int i = 0; i < M; i++) {
                String record = st.nextToken();
                if (record.charAt(0) == '.') {
                    length++;
                } else {
                    maxLength = Math.max(maxLength, length);
                    length = 0;
                }

            }
            maxLength = Math.max(maxLength, length);
            set.add(maxLength);
            sb.append(maxLength)
                    .append(' ')
                    .append(st.nextToken())
                    .append('\n');
        }

        bw.write(String.valueOf(set.size()));
        bw.newLine();

        bw.write(sb.toString());
        bw.flush();
    }

}
