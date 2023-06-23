import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 1-n;
        while(n-->0){
            answer += Integer.parseInt(br.readLine());
        }
        System.out.println(answer);

    }

}
