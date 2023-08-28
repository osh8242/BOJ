import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        if(M-m < T) {
            System.out.println(-1);
            return;
        }
        int time = 0;
        int X = m;
        while(true){
            time++;
            if(X+T <= M) {
                N--;
                X += T;
            } else X = X-R < m ? m : X-R;
            if( N == 0 ) break;
        }
        System.out.println(time);
    }

}
