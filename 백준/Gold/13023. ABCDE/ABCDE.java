import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<List<Integer>> relations;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relations = new ArrayList<>(N);
        isVisit = new boolean[N];
        for (int i = 0; i < N; i++)
            relations.add(new ArrayList<>());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            relations.get(person1).add(person2);
            relations.get(person2).add(person1);
        }
        dfs();
        System.out.println(0);
    }

    static void dfs() {
        for (int i = 0; i < N - 1; i++) {
            isVisit[i] = true;
            findRelation(i, 1);
            isVisit[i] = false;
        }
    }

    static void findRelation(int person, int depth) {
        if (depth == 5) {
            System.out.println(1);
            System.exit(0);
        }
        for (Integer friend : relations.get(person)) {
            if (!isVisit[friend]) {
                isVisit[friend] = true;
                findRelation(friend, depth + 1);
                isVisit[friend] = false;
            }
        }
    }

}