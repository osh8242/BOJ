import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        sb.append(getLCM(n,m)+"\n");
        System.out.println(sb);

    }

    static long getLCM(int n, long m){
        long answer = 1;
        int min = (int)Math.min(n,m);
        for(int i = 2 ; i <= min ; i++){
            if(n%i == 0 && m%i == 0){
                m /= i;
                n /= i;
                answer *= i;
                i--;
            }
        }

        return answer*n*m;
    }
}
