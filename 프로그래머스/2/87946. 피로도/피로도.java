class Solution {
    
    static int answer = 0;
    static int[][] dungeons = null;
    static boolean[] isVisit = null;
    
    public int solution(int k, int[][] dungeons) {
        Solution.dungeons = dungeons;
        Solution.isVisit = new boolean[dungeons.length];
        dfs(k, 0);
        return answer;
    }
    
    void dfs(int k, int count) {
        if(count > answer) answer = count;
        for(int i = 0 ; i < dungeons.length ; i++) {
            if(!isVisit[i] && dungeons[i][0] <= k) {
                isVisit[i] = true;
                dfs(k - dungeons[i][1], count + 1);
                isVisit[i] = false;
            }
        }
    }
}