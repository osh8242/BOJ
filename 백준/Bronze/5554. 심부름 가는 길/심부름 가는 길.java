import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 1 ; i <= 4 ; i++){
            sum += Integer.parseInt(br.readLine());
        }
        sb.append(sum/60+"\n");
        sb.append(sum%60);
        System.out.println(sb.toString());
    }
}
