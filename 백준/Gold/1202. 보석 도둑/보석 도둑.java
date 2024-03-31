import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jewels);
        Collections.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long maxValue = 0;
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && jewels.get(j).weight <= bags.get(i)) {
                pq.add(jewels.get(j).value);
                j++;
            }
            if (!pq.isEmpty()) {
                maxValue += pq.poll();
            }
        }

        System.out.println(maxValue);
    }
}
