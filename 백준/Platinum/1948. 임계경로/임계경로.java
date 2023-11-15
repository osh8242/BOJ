import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, startCity, endCity;
    static ArrayList<Node>[] list;
    static int[] indegrees;
    static int[] criticalPaths;

    private void solution() throws IOException {
        ArrayList<Node>[] reverse = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) reverse[i] = new ArrayList<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, time));
            reverse[end].add(new Node(start, time));
            indegrees[end]++;
        }
        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        que.offer(startCity);
        while (!que.isEmpty()) {
            int current = que.poll();
            for (Node next : list[current]) {
                indegrees[next.index]--;
                criticalPaths[next.index] =
                        Math.max(criticalPaths[next.index], criticalPaths[current] + next.time);
                if (indegrees[next.index] == 0) que.offer(next.index);
            }
        }
        int roadCount = 0;
        boolean[] isVisited = new boolean[n + 1];
        que = new LinkedList<>();
        que.offer(endCity);
        while (!que.isEmpty()) {
            int current = que.poll();
            for (Node next : reverse[current]) {
                if (criticalPaths[next.index] + next.time == criticalPaths[current]) {
                    roadCount++;
                    if (!isVisited[next.index]) {
                        isVisited[next.index] = true;
                        que.offer(next.index);
                    }
                }
            }
        }
        System.out.println(criticalPaths[endCity] + "\n" + roadCount);
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        indegrees = new int[n + 1];
        criticalPaths = new int[n + 1];

        new Main().solution();
    }

    class Node {
        private int index;
        private int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

}
