import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        return myString.chars()
            .map(v -> v < 'l' ? 'l' : v)
            .mapToObj(v -> String.valueOf((char) v))
            .collect(Collectors.joining(""));
    }
}