import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Character,Integer> tierMap = Map.of(
        'B', 0,
        'S', 1,
        'G', 2,
        'P', 3,
        'D', 4
    );

    static int difficulty(String s) {
        int tierIdx = tierMap.get(s.charAt(0));
        int step = Integer.parseInt(s.substring(1));
        int within = 1001 - step;
        return tierIdx * 1000 + within;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr = br.readLine().split(" ");
        String[] sorted = arr.clone();
        Arrays.sort(sorted, Comparator.comparingInt(Main::difficulty));

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!arr[i].equals(sorted[i])) diff.add(i);
        }

        if (diff.isEmpty()) {
            System.out.println("OK");
        } else {
            System.out.println("KO");
            int i = diff.get(0), j = diff.get(1);
            String a = arr[i], b = arr[j];
            if (difficulty(a) < difficulty(b)) {
                System.out.println(a + " " + b);
            } else {
                System.out.println(b + " " + a);
            }
        }
    }
}
