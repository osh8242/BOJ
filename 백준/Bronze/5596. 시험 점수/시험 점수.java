import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 1 ; i <=4 ; i++){
            sum += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int sum2 = 0;
        for(int i = 1 ; i <=4 ; i++){
            sum2 += Integer.parseInt(st.nextToken());
        }
        System.out.println(sum<sum2?sum2:sum);

    } // void main()
} //Class Main