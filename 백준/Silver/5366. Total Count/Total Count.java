import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String fighter;
        while (!(fighter = br.readLine()).equals("0")) {
            int count = map.getOrDefault(fighter, 0);
            if (count == 0) list.add(fighter);
            map.put(fighter, count + 1);

        }
        StringBuilder sb = new StringBuilder();
        int totalCount = 0;
        for (String name : list) {
            int count = map.get(name);
            totalCount += count;
            sb.append(name).append(": ").append(count).append("\n");            
        }
        sb.append("Grand Total: ").append(totalCount);
        System.out.println(sb);
    }

}
