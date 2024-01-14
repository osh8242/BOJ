import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            sb.append(test_case++).append(". ");

            boolean isEven = N % 2 ==0;
            sb.append(isEven ? "even" : "odd").append(" ");

            if(!isEven) N--;
            sb.append(N/2).append("\n");
        }
        System.out.println(sb);
    }

}