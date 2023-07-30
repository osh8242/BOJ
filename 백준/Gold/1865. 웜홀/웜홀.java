import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static class Node {
        int index;
        int price;

        public Node(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    static ArrayList<Node>[] paths;
    static int n;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            paths = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) paths[i] = new ArrayList<>();

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                paths[s].add(new Node(e, t));
                paths[e].add(new Node(s, t));
            }
            while (w-- > 0) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                paths[s].add(new Node(e, -t));
            }

            sb.append(Bellman_Ford() ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }

    static boolean Bellman_Ford() {
        int[] totalPrices = new int[n + 1];
        Arrays.fill(totalPrices, INF);
        totalPrices[1] = 0;
        boolean isUpdated = false;

        for (int count = 1; count < n; count++) {
            isUpdated = false;
            for (int start = 1; start <= n; start++) {
                if(totalPrices[start] == Integer.MAX_VALUE) continue;
                for (Node end : paths[start]) {
                    if (totalPrices[end.index] > totalPrices[start] + end.price) {
                        isUpdated = true;
                        totalPrices[end.index] = totalPrices[start] + end.price;
                    }
                }
            }
            if (!isUpdated) break;
        }

        if (isUpdated) {
            for (int start = 1; start <= n; start++) {
                for (Node end : paths[start]) {
                    if (totalPrices[end.index] > totalPrices[start] + end.price) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
