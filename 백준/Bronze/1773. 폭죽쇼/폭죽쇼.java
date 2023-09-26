import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] periods = new int[n+1];
        int c = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            periods[i] = Integer.parseInt(br.readLine());
        }
        int answer = 0;
        for(int i = 1 ; i <= c ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i%periods[j] == 0) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
