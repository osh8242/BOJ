import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int combo = 1;
        int score = 0;
        while(n-->0){
            if(Integer.parseInt(st.nextToken()) == 1) score += combo++;
            else combo = 1;
        }
        System.out.println(score);
    }
}
