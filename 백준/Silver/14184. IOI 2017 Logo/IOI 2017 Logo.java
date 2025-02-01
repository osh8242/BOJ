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
            for (int i = 0; i < N; i++) {
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
            Collection<Logo> logos = map.values();
            int maxScore = Integer.MIN_VALUE;
            for (Logo l : logos) {
                if (l.totalScore > maxScore) maxScore = l.totalScore;
            }
            List<Logo> cand = new ArrayList<>();
            for (Logo l : logos) {
                if (l.totalScore == maxScore) cand.add(l);
            }
            int maxFirst = Integer.MIN_VALUE;
            for (Logo l : cand) {
                if (l.votes[1] > maxFirst) maxFirst = l.votes[1];
            }
            List<Logo> cand2 = new ArrayList<>();
            for (Logo l : cand) {
                if (l.votes[1] == maxFirst) cand2.add(l);
            }
            int maxSecond = Integer.MIN_VALUE;
            for (Logo l : cand2) {
                if (l.votes[2] > maxSecond) maxSecond = l.votes[2];
            }
            List<Logo> winners = new ArrayList<>();
            for (Logo l : cand2) {
                if (l.votes[2] == maxSecond) winners.add(l);
            }
            winners.sort(Comparator.comparingInt(a -> a.index));
            for (Logo w : winners) sb.append(w.index).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int getPoint(int order) {
        return MAX_POINT - (order - 1) * POINT_STEP;
    }
    static class Logo {
        int index;
        int totalScore;
        int[] votes;
        public Logo(int index) {
            this.index = index;
            this.totalScore = 0;
            this.votes = new int[4];
        }
    }
}
