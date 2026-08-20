import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(int[] numLog) {
        return IntStream.range(1, numLog.length)
            .mapToObj(idx -> getChar(numLog[idx] - numLog[idx - 1]))
            .collect(Collectors.joining());
    }

    private String getChar(int diff) {
        return switch (diff) {
            case 1 -> "w";
            case -1 -> "s";
            case 10 -> "d";
            case -10 -> "a";
            default -> "";
        };
    }
}