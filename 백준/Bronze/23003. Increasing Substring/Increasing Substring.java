import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            char[] chars = br.readLine().toCharArray();
            int length = 1;
            sb.append("Case #").append(t).append(": 1 ");
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] > chars[i - 1]) length++;
                else length = 1;
                sb.append(length).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
