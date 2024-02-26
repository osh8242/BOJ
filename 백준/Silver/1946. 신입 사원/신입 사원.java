import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Rank> list = new ArrayList<>(2 * N);
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Rank(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list);
            int answer = 1;
            int minInterview = list.get(0).interview;
            for(int i = 1 ; i < list.size() ; i++){
                if(list.get(i).interview < minInterview){
                    answer++;
                    minInterview = list.get(i).interview;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static class Rank implements Comparable<Rank> {
        private final int paper;
        private final int interview;

        public Rank(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public int compareTo(Rank o) {
            return this.paper > o.paper ? 1 : -1;
        }
    }

}