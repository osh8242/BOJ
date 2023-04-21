import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> p = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(p.containsKey(temp)) p.put(temp, p.get(temp)+1);
            else p.put(temp, 1);
        }
        int sum = 0;
        while(p.size() != 0){
            int temp = p.firstKey();
            sum += (n--)*temp;
            p.put(temp, p.get(temp)-1);
            if(p.get(temp)==0) p.remove(temp);
        }
        System.out.println(sum);

    }
}