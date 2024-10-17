class Solution {
    
    static int minCount = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, new boolean[words.length], 0);
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
    
    void dfs(String begin, String target, String[] words, boolean[] isVisit, int count) {
        if(minCount <= count) return;
        if(begin.equals(target)) {
            if(minCount > count) minCount = count;
            return;
        }
        for(int i = 0 ; i < words.length ; i++) {
            if(!isVisit[i] && countDifferent(begin, words[i]) == 1) {
                isVisit[i] = true;
                dfs(words[i], target, words, isVisit, count + 1);
                isVisit[i] = false;
            }            
        }
    }
    
    int countDifferent(String begin, String word) {
        int count = 0;
        for (int i = 0 ; i < begin.length() ; i++) {
            if(begin.charAt(i) != word.charAt(i)) count++;
        }
        return count;
    }
}

class Count {
    int value = 0;
}