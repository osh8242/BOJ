import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int E_PERIOD = 15;
    static int S_PERIOD = 28;
    static int M_PERIOD = 19;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 1 ; ; i++){
            int e = i%E_PERIOD == 0 ? E_PERIOD : i%E_PERIOD;
            int s = i%S_PERIOD == 0 ? S_PERIOD : i%S_PERIOD;
            int m = i%M_PERIOD == 0 ? M_PERIOD : i%M_PERIOD;
            if(e == E && s == S && m == M){
                System.out.println(i);
                return;
            }
        }


    }


}
