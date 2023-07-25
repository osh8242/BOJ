import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int test_case = 1 ; test_case <= n ; test_case++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int reward = -1;
            if(a==b && a==c) reward = 10000+a*1000;
            else if (a != b && b != c && c != a) reward = 100*Math.max(a,Math.max(b,c));
            else {
                if(a==b) reward = 1000+a*100;
                else if (b==c) reward = 1000+b*100;
                else reward = 1000+c*100;
            }
            max = reward > max ? reward : max;
        }
        System.out.println(max);

    }
}
