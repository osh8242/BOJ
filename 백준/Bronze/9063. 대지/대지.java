import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> tsx = new TreeSet<>();
        TreeSet<Integer> tsy = new TreeSet<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tsx.add(Integer.parseInt(st.nextToken()));
            tsy.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println(
                (tsx.last()-tsx.first())*(tsy.last()-tsy.first())
        );
    }

}
