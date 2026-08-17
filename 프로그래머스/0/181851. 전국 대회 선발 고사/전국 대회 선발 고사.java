import java.util.PriorityQueue;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int n = rank.length;
        int[] studentsByRank = new int[n+1];
        for(int i = 0 ; i < n ; i++) {
            studentsByRank[rank[i]] = i;
        }
        int count = 3;
        int answer = 0;
        for(int i = 1 ; i < n+1 ; i++) {
            if(attendance[studentsByRank[i]]) {
                answer += studentsByRank[i] * Math.pow(100, count-1);
                count--;
            }
            if(count == 0) break;
        }
        return answer;
    }
}