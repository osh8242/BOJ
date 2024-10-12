import java.util.Set;
import java.util.HashSet;

class Solution {
    
    static String[] pronounces = {"aya", "ye", "woo", "ma"};
    static Set<String> set = new HashSet<>();
    
    static {
        generatePronounceCombination();
    }
    
    public int solution(String[] babbling) {
        int answer = 0;

        for(String str : babbling) {
            if(set.contains(str)) answer++;
        }
        return answer;
    }
  
    static void generatePronounceCombination() {
        for(int i = 0 ; i < pronounces.length ; i++) {
            boolean[] isVisit = new boolean[pronounces.length];
            isVisit[i] = true;
            dfs(i, new StringBuilder(), isVisit);
        }
    }
    
    static void dfs(int index, StringBuilder sb, boolean[] isVisit) {
        sb.append(pronounces[index]);
        set.add(sb.toString());

        for(int i = 0 ; i < pronounces.length ; i++) {            
            if(!isVisit[i])  {
                isVisit[i] = true;
                dfs(i, new StringBuilder(sb), isVisit);
                isVisit[i] = false;
            }
        }
    }
}