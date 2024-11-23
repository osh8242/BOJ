import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<Cow> cows = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows.add(new Cow(x, y, i));
        }

        int taggedCount = 0;
        int currentIndex = 0;

        while (taggedCount < N - 1) {
            while (cows.get(currentIndex).isTagged) { // 현재 소가 이미 태그된 경우 다음 소로 이동
                currentIndex = (currentIndex + 1) % N; // 인덱스를 순환하도록 처리
            }

            Cow current = cows.get(currentIndex);
            PriorityQueue<Distance> que = new PriorityQueue<>();
            for (Cow candidate : cows) {
                if (candidate.isTagged || candidate.idx == current.idx) continue;
                que.offer(new Distance(candidate.idx, current.getDistanceWith(candidate)));
            }

            Cow closest = cows.get(que.poll().idx);
            closest.isTagged = true;
            taggedCount++;


            currentIndex = (currentIndex + 1) % N;
        }

        for (Cow cow : cows) {
            if (!cow.isTagged) {
                System.out.println(cow.idx + 1);
                break;
            }
        }
    }
}

class Cow {
    int x, y, idx;
    boolean isTagged;

    public Cow(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
        this.isTagged = false;
    }

    public long getDistanceWith(Cow other) {
        long dx = this.x - other.x;
        long dy = this.y - other.y;
        return dx * dx + dy * dy;
    }
}

class Distance implements Comparable<Distance> {
    int idx;
    long distance;

    public Distance(int idx, long distance) {
        this.idx = idx;
        this.distance = distance;
    }

    @Override
    public int compareTo(Distance o) {
        return Long.compare(this.distance, o.distance);
    }
}
