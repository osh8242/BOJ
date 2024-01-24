import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        boolean existZero = false;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(input[i]);
            existZero = num == 0 || existZero;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int num : map.keySet()) {
            if (num == map.get(num) && num > max) max = num;
        }
        System.out.println(max != 0 ? max : existZero ? -1 : 0);
    }

}