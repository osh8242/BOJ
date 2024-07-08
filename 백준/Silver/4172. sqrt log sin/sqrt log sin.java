import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int MOD = 1000000;
    private static final int MAX_I = 1000000;
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 초기값 설정
        memo.put(0, 1);
        
        while (true) {
            int i = scanner.nextInt();
            if (i == -1) {
                break;
            }
            System.out.println(getX(i));
        }
        
        scanner.close();
    }
    
    private static int getX(int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        int a = (int) (i - Math.sqrt(i));
        int b = (int) Math.log(i);
        int c = (int) (i * Math.pow(Math.sin(i), 2));
        
        int result = (getX(a) + getX(b) + getX(c)) % MOD;
        memo.put(i, result);
        
        return result;
    }
}
