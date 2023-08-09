import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int index = 1;
        while(index * index <= n){
            answer++;
            index++;
        }
        System.out.println(answer);

    }

}
