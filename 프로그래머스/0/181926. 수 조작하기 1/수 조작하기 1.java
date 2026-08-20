class Solution {
    public int solution(int n, String control) {        
        return n + control.chars()
            .map(ch -> getValue((char) ch))
            .sum();
    }
    
    private int getValue(char ch) {
        return switch (ch) {
            case 'w' -> 1;
            case 's' -> -1;
            case 'd' -> 10;
            case 'a' -> -10;
            default -> 0;
        };
    }
}