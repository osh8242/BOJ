class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] arr = binomial.split(" ");
        int a = Integer.parseInt(arr[0]);
        char op = arr[1].charAt(0);
        int b = Integer.parseInt(arr[2]);
        return switch(op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> 0;
        };
    }
}