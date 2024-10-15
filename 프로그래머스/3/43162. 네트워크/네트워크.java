class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isVisit = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (!isVisit[i]) {
                answer++;
                dfs(i, computers, isVisit);
            }
        }
        return answer;
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
