import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a >= L && b >= L && c >= L && (a + b + c) >= K) {
                list.add(a);
                list.add(b);
                list.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size() / 3).append("\n");
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
