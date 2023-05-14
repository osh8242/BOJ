import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isBroken = new boolean[10];
    static char[] channel;
    static char[] btnInput;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;
        for(int t = 0 ; t < n ; t++){
            int time = Integer.parseInt(st.nextToken());
            y += (time/30+1)*10;
            m += (time/60+1)*15;
        }
        StringBuilder sb = new StringBuilder();
        if(y > m) sb.append("M "+m);
        else if (y == m) sb.append("Y M "+y);
        else sb.append("Y "+y);
        System.out.println(sb.toString());

    }

}