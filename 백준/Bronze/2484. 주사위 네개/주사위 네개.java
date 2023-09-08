import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int answer = Integer.MIN_VALUE;
        int[] prizes = new int[T + 1];
        for (int test_case = 1; test_case <= T; test_case++) {
            int[] diceCounter = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 4; i++) {
                diceCounter[Integer.parseInt(st.nextToken())]++;
            }
            int prize = getPrize(diceCounter);
            answer = Math.max(prize, answer);
        }
        System.out.println(answer);
    }

    static int getPrize(int[] diceCounter) {
        int prize = 0;
        for (int i = 1; i < 7; i++) {
            if (diceCounter[i] == 4) return 50000 + i * 5000;
            if (diceCounter[i] == 3) return 10000 + i * 1000;
        }
        int count = 0;
        for(int i = 1 ; i < 7 ; i++){
            if(diceCounter[i] != 0) count++;
        }
        if(count == 2) {
            prize += 2000;
            for(int i = 1 ; i < 7 ; i++){
                if(diceCounter[i] == 2) prize += i*500;
            }
        }
        if (count == 3) {
            prize += 1000;
            for(int i = 1 ; i < 7 ; i++){
                if(diceCounter[i] == 2) prize += i*100;
            }
        }
        if(count ==4) {
            int max = Integer.MIN_VALUE;
            for(int i = 1 ; i < 7 ; i++){
                if(diceCounter[i] == 1) max = i;
            }
            prize += max*100;
        }

        return prize;
    }


}
