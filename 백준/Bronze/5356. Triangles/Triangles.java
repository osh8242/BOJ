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
            char ch = st.nextToken().charAt(0);
            appendTriangle(N, ch, sb);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void appendTriangle(int N, char ch, StringBuilder sb) {
        for (int i = 1; i <= N ; i++) {
            sb.append(String.valueOf(ch).repeat(i)).append("\n");            
            ch += (char) (ch == 90 ? -25 : 1);
        }
    }
    
}
