import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int test_case = 1 ; test_case <= T ; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int persons = Integer.parseInt(st.nextToken());
            int apples = Integer.parseInt(st.nextToken());
            sum += apples % persons;
        }
        System.out.println(sum);
    }
}
