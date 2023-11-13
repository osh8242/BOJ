import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int A, B, C;
    static int[] maxCapacity;
    static boolean[][] isVisited;
    static boolean[] availableCapicity;

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maxCapacity = new int[]{A, B, C};
        isVisited = new boolean[A + 1][B + 1];
        availableCapicity = new boolean[C + 1];
        bfs();
        for (int i = 0; i < availableCapicity.length; i++) {
            if (availableCapicity[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    void bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, C});
        while (!que.isEmpty()) {
            int[] status = que.poll();
            isVisited[status[0]][status[1]] = true;
            if (status[0] == 0) availableCapicity[status[2]] = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == j) continue;
                    int[] newStatus = watering(status, i, j);
                    if (newStatus != null && !isVisited[newStatus[0]][newStatus[1]]) {
                        que.add(newStatus);
                    }
                }
            }

        }
    }

    int[] watering(int[] status, int sender, int receiver) {
        int residue = maxCapacity[receiver] - status[receiver];
        if (residue == 0 || status[sender] == 0) return null;
        int[] newStatus = status.clone();
        if (residue < newStatus[sender]) {
            newStatus[sender] -= residue;
            newStatus[receiver] += residue;
        } else {
            newStatus[receiver] += newStatus[sender];
            newStatus[sender] = 0;
        }
        return newStatus;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}
