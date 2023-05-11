import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sb.append("The largest square has side length ");
        sb.append((int)Math.sqrt(n)+".");
        System.out.println(sb.toString());

    }//main
}//Class