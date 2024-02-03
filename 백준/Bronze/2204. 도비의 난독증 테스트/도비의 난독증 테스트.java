import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            Queue<Word> que = new PriorityQueue<>();
            while (N-- > 0) {
                String origin = br.readLine();
                que.offer(new Word(origin));
            }
            sb.append(que.poll().origin).append("\n");
        }
        System.out.println(sb);
    }

    static class Word implements Comparable<Word> {
        String origin;
        String lower;

        public Word(String origin) {
            this.origin = origin;
            this.lower = origin.toLowerCase();
        }

        @Override
        public int compareTo(Word o) {
            return this.lower.compareTo(o.lower);
        }
    }

}