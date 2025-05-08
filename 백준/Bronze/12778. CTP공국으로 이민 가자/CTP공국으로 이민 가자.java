import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            char type = st.nextToken().charAt(0);
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if (type == 'C') {
                    char ch = st.nextToken().charAt(0);
                    sb.append((ch - 'A' + 1));
                } else { // type == 'N'
                    int num = Integer.parseInt(st.nextToken());
                    sb.append((char)('A' + num - 1));
                }
                if (i < M - 1) sb.append(' ');
            }
            if (T > 0) sb.append('\n');
        }
        
        System.out.print(sb);
    }
}
