import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            String line = br.readLine();
            if(line.toCharArray()[1] == '=') {
                sb.append("skipped").append("\n");
            }else {
                StringTokenizer st = new StringTokenizer(line, "+");
                sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
            }
        }
        System.out.println(sb);
    }
}
