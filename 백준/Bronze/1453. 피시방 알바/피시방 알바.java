import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countOfRefusal = 0;
        Set<Integer> set = new HashSet<>();
        while (n-- > 0) {
            if (!set.add(Integer.parseInt(st.nextToken()))) countOfRefusal++;
        }
        System.out.println(countOfRefusal);

    }

}
