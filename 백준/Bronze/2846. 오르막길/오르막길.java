import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int answer = 0;
        int lowest = 1000;
        int prev = 1000;
        boolean isHigher;
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(input[i]);
            isHigher = next > prev;
            if (!isHigher) lowest = next;
            else answer = Math.max(answer, next - lowest);
            prev = next;
        }
        System.out.println(answer);
    }

}