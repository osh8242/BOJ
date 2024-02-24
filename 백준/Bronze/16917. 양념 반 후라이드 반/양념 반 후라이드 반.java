import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        
        int price = Math.min(2 * C, A + B);
        int answer = 0;
        int min = Math.min(X, Y);
        answer += min * price;

        if (X > Y) price = Math.min(2 * C, A);
        else if (X < Y) price = Math.min(2 * C, B);
        answer += Math.abs(X - Y) * price;

        System.out.println(answer);
    }

}