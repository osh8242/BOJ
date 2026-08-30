import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        return myString.chars()
            .mapToObj(ch -> String.valueOf((char) (ch == 'a' ? 'A' : ch <= 'Z' && ch >= 'B'? ch + 32 : ch)))
            .collect(Collectors.joining(""));
    }
}