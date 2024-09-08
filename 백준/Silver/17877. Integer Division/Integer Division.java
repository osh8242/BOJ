import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);

        String[] numbers = br.readLine().split(" ");

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int ai = Integer.parseInt(numbers[i]);
            int quotient = ai / d;
            freqMap.put(quotient, freqMap.getOrDefault(quotient, 0) + 1);
        }

        long pairCount = 0;
        for (int count : freqMap.values()) {
            if (count > 1) {
                pairCount += (long) count * (count - 1) / 2;
            }
        }

        bw.write(String.valueOf(pairCount));
        bw.flush();
    }
}
