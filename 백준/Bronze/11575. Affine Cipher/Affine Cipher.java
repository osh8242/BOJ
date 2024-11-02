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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            char[] ciphers = new char[26];
            for (int i = 0; i < 26; i++) {
                ciphers[i] = (char) ((a * i + b) % 26 + 'A');
            }

            char[] chars = br.readLine().toCharArray();
            for (char c : chars) sb.append(ciphers[c - 'A']);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
