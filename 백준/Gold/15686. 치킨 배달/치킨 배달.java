import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> house = new ArrayList<>();
    static int[][] distances;
    static boolean[] selected;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) house.add(new Node(i, j));
                else if (value == 2) chicken.add(new Node(i, j));
            }
        }

        distances = new int[house.size()][chicken.size()];
        selected = new boolean[chicken.size()];

        calculateDistances();
        selectChickenShops(0, 0);
        System.out.println(minDistance);
    }

    static void calculateDistances() {
        for (int i = 0; i < house.size(); i++) {
            for (int j = 0; j < chicken.size(); j++) {
                distances[i][j] = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
            }
        }
    }

    static void selectChickenShops(int start, int count) {
        if (count == M) {
            int distanceSum = calculateTotalDistance();
            minDistance = Math.min(minDistance, distanceSum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                selectChickenShops(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    static int calculateTotalDistance() {
        int total = 0;
        for (int i = 0; i < house.size(); i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++) {
                if (selected[j]) {
                    minDist = Math.min(minDist, distances[i][j]);
                }
            }
            total += minDist;
        }
        return total;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
