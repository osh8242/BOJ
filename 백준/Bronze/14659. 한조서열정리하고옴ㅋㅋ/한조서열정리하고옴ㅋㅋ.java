import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ref = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i = 1 ; i < n ; i++){
            int height = Integer.parseInt(st.nextToken());
            if(height < ref) {
                count++;
            } else {
                ref = height;
                answer = count>answer?count:answer;
                count=0;
            }
        }
        System.out.println(answer>count?answer:count);

    }

}
