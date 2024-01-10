import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i = 1 ; i <= N ; i++){
            int student = Integer.parseInt(st.nextToken());
            if(student != i) answer++;
        }
        System.out.println(answer);
    }

}