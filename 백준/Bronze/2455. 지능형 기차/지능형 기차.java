import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int num = 0;
        for(int i = 1 ; i <= 4 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            num += -Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            max = num > max ? num : max;
        }
        System.out.println(max);
    }
}
