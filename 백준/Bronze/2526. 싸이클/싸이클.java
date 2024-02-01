import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] elements = new int[Math.max(N + 1, P)];

        int answer = 1;
        int index = 1;
        int num = N;
        elements[N] = 1;
        while (true) {
            index++;
            num = num * N % P;
            if (elements[num] == 0) {
                elements[num] = index;
            } else {
                System.out.println(index - elements[num]);
                break;
            }
        }
    }

}