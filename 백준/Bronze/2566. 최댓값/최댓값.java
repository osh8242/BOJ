import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int max = -1;
        int x = 0;
        int y = 0;
        for(int i = 1 ; i <= 9 ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= 9 ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num > max) {
                    max = num;
                    x = i;
                    y = j;
                }
            }
        }
        sb.append(max+"\n");
        sb.append(x+" "+y);
        System.out.println(sb.toString());
    }
}