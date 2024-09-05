import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();

            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }

            for (int i = 0; i < e; i++) {
                int person = Integer.parseInt(br.readLine().trim());
                queue.remove((Integer) person);
                queue.addFirst(person);
            }

            sb.append(queue.getLast()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
