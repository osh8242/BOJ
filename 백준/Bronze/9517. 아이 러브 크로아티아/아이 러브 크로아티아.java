import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int COUNT_OF_MAN = 8;
    static final int LIMIT_OF_TIME = 210;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int current = Integer.parseInt(br.readLine());
        int time = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time += t;
            if(time >= LIMIT_OF_TIME) break;
            String z = st.nextToken();
            if(z.equals("T")) current++;
            if(current > COUNT_OF_MAN) current = 1;
        }

        System.out.println(current);
    }

}
