import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    //후보자 정보
    static final Candidate[] candidates = new Candidate[4];

    public static void main(String[] args) throws IOException {
        // 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < candidates.length; i++) {
            candidates[i] = new Candidate(i);
        }

        // 입력받기
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < candidates.length; i++) {
                int point = Integer.parseInt(st.nextToken());
                candidates[i].addPoint(point);
            }
        }

        // 우승자 가리기
        Candidate prior = new Candidate(0);
        boolean isDuplicated = false;
        for (int i = 1; i < candidates.length; i++) {
            Candidate candidate = candidates[i];
            int param = prior.compareTo(candidate);
            if (param == 0) isDuplicated = true;
            if (param > 0) {
                isDuplicated = false;
                prior = candidate;
            }
        }

        // 정답 출력
        System.out.printf("%d %d", isDuplicated ? 0 : prior.index, prior.point);
    }

    // 후보자 객체
    static class Candidate implements Comparable<Candidate> {
        private int index;
        private int point;
        private int count3;
        private int count2;

        public Candidate(int index) {
            this.index = index;
            this.point = 0;
            this.count3 = 0;
            this.count2 = 0;
        }

        public void addPoint(int point) {
            switch (point) {
                case 3:
                    count3++;
                    break;
                case 2:
                    count2++;
                    break;
            }
            this.point += point;
        }

        @Override
        public int compareTo(Candidate o) {
            return o.point == this.point ?
                    o.count3 == this.count3 ?
                            o.count2 - this.count2 :
                            o.count3 - this.count3 :
                    o.point - this.point
                    ;
        }
    }
}