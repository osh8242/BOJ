import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MAX_POINT = 3;
    static final int POINT_STEP = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            Map<Integer, Logo> map = new HashMap<>();

            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());

                int order = 1;
                while (d-- > 0) {
                    int index = Integer.parseInt(st.nextToken());
                    Logo logo = map.get(index);
                    if (logo == null) {
                        logo = new Logo(index);
                        map.put(index, logo);
                    }
                    int point = getPoint(order);
                    logo.totalScore += point;
                    logo.votes[order]++;
                    order++;
                }
            }

            Logo[] logos = map.values().toArray(new Logo[0]);
            Arrays.sort(logos);
            List<Logo> winners = new ArrayList<>();
            winners.add(logos[0]);
            for (int i = 1; i < logos.length; i++) {
                if (logos[i].compareTo(logos[0]) == 0) {
                    winners.add(logos[i]);
                } else {
                    break;
                }
            }
            winners.sort(Comparator.comparingInt(a -> a.index));
            for (Logo winner : winners) {
                sb.append(winner.index).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    static int getPoint(int order) {
        return MAX_POINT - (order - 1) * POINT_STEP;
    }

    static class Logo implements Comparable<Logo> {
        int index;
        int totalScore;
        int[] votes;

        public Logo(int index) {
            this.index = index;
            this.totalScore = 0;
            int capacity = MAX_POINT / POINT_STEP + 1;
//            if (MAX_POINT % POINT_STEP != 0) capacity++;
            // 1-base index
            this.votes = new int[capacity + 1];
        }

        @Override
        public int compareTo(Logo o) {
            if (this.totalScore != o.totalScore) {
                return Integer.compare(o.totalScore, this.totalScore);
            } else if (this.votes[1] != o.votes[1]) {
                return Integer.compare(o.votes[1], this.votes[1]);
            } else if (this.votes[2] != o.votes[2]) {
                return Integer.compare(o.votes[2], this.votes[2]);
            } else {
                return 0;
            }
        }
    }

}