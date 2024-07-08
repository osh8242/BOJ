import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int MOD = 1000000;
    private static final int MAX_I = 1000000;
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        
        // 초기값 설정
        memo.put(0, 1);

        while (true) {
            String line = reader.readLine();
            int i = Integer.parseInt(line.trim());
            if (i == -1) {
                break;
            }
            output.append(getX(i)).append("\n");
        }
        
        writer.write(output.toString());
        writer.flush();
        reader.close();
        writer.close();
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
