import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1 ; test_case <= T ; test_case++){
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(n-->0){
                sum += Integer.parseInt(st.nextToken());
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }

}
