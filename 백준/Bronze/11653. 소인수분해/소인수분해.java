import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int i = 2;
        while(n != 1){
            if(n % i == 0){
                sb.append(i+"\n");
                n /= i;
            } else i++;
        }
        System.out.println(sb);
    }
}
