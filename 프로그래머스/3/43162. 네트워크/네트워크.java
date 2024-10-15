class Solution {
    public int solution(int n, int[][] computers) {
        Count count = new Count();
        boolean[] isVisit = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (!isVisit[i]) {
                count.value++;
                dfs(i, computers, isVisit);
            }
        }
        return count.value;
    }

    void dfs(int current, int[][] computers, boolean[] isVisit) {
        isVisit[current] = true;
        
        for (int next = 0; next < computers.length; next++) {
            if (!isVisit[next] && computers[current][next] == 1) {
                dfs(next, computers, isVisit);
            }
        }
    }
}

class Count {
    int value = 0;
}
