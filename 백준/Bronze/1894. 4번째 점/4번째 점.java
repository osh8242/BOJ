import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력이 없을 때까지 반복
        String line = "";
        while ((line = br.readLine()) != null) {
            // 입력줄을 Double 배열로 변환
            Double[] coordinates = Arrays.stream(line.split(" "))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);

            // Double 배열로 각 Point 배열 생성
            Point[] points = new Point[coordinates.length / 2];
            for (int i = 0; i < coordinates.length; i += 2) {
                points[i / 2] = new Point(coordinates[i], coordinates[i + 1]);
            }

            // 중복된 Point(교점)을 찾아서 표시하기
            Point crossPoint = new Point(null, null);
            boolean[] isVisit = new boolean[4];
            outer:
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (points[i].isEqual(points[j])) {
                        isVisit[i] = true;
                        isVisit[j] = true;
                        crossPoint = points[i];
                        break outer;
                    }
                }
            }

            // 교점에서 다른 점으로의 벡터값을 얻고 4번째 점 구하기
            Point vector = null;
            for (int i = 0; i < 4; i++) {
                if (!isVisit[i]) {
                    if (vector == null)
                        // '교점'에서부터 '교점이 아닌 점'으로의 벡터얻기
                        vector = crossPoint.getVector(points[i]);
                    else {
                        // 남은 한 점에서부터 4번째 점으로의 벡터 이동
                        Point p4 = points[i].addVector(vector);
                        sb.append(String.format("%.3f %.3f\n", p4.x, p4.y));
                    }
                }
            }
        }
        // 정답 출력
        System.out.println(sb);
    }

    // x,y 좌표를 갖는 Point 객체
    static class Point {
        private final Double x;
        private final Double y;

        public Point(Double x, Double y) {
            this.x = x;
            this.y = y;
        }

        public Point addVector(Point p) {
            return new Point(this.x + p.x, this.y + p.y);
        }

        public boolean isEqual(Point p) {
            return Objects.equals(this.x, p.x) && Objects.equals(this.y, p.y);
        }

        public Point getVector(Point goal) {
            return new Point(goal.x - this.x, goal.y - this.y);
        }
    }
}