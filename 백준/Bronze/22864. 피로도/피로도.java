import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int dayTime = 24;
        int fatigue = 0;
        int done = 0;
        while(dayTime-->0){
            if(fatigue + A <= M){
                fatigue += A;
                done += B;
            } else {
                fatigue = Math.max(fatigue - C, 0);
            }
        }
        System.out.println(done);
    }


}
