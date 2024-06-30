import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            cows[i] = new Cow(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        int groupCount = 1;
        Cow tail = cows[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            Cow current = cows[i];
            if (current.speed > tail.speed) {
                current.speed = tail.speed;
                tail = current;
            } else {
                groupCount++;
                tail = current;
            }
        }
        System.out.println(groupCount);
    }

    static class Cow {
        int position;
        int speed;

        public Cow(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
