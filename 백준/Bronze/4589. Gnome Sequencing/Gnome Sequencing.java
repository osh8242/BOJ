import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("Gnomes:\n");
        int T = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= T ; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if( (a>=b && b>=c) || (a<=b && b<=c) ){
                sb.append("Ordered\n");
            } else sb.append("Unordered\n");
        }
        System.out.println(sb);
    }//main
}//Class