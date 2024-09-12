import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            br.readLine();
            Set<String> set = new HashSet<>();
            List<String> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                boolean b = set.add(s);
                if (b) list.add(s);
            }
            for (String s : list) {
                sb.append(s).append(" ");
            }
            sb.append('\n');
        }


        bw.write(sb.toString());
        bw.flush();
    }

}
