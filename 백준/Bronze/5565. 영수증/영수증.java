import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        int booksNum = 9;
        while(booksNum-- > 0){
            sum -= Integer.parseInt(br.readLine());
        }
        System.out.println(sum);

    }
}
