import java.util.stream.Collectors;

class Solution {
    public int solution(String myString, String pat) {
        return myString.chars()
            .map(s -> s == 'A' ? 'B' : s == 'B' ? 'A' : s)
            .mapToObj(s -> String.valueOf((char) s))
            .collect(Collectors.joining(""))
            .contains(pat) ? 1 : 0;        
    }
}