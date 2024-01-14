import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        System.out.println(Math.min(
                getFee(P, A),
                getFee(P, B, C, D)
        ));
    }

    static int getFee(int usage, int usageFee) {
        return usage * usageFee;
    }

    static int getFee(int usage, int defaultFee, int limit, int usageFee) {
        int answer = defaultFee;
        if (usage > limit) answer += (usage - limit) * usageFee;
        return answer;
    }

}