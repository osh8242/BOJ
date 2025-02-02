import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        while (S1-- > 0) {
            st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken());
            int submit = Integer.parseInt(st.nextToken());
            if (!validateSubmit(submit, answer, "Wrong Answer")) return;
        }
        while (S2-- > 0) {
            st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken());
            int submit = Integer.parseInt(st.nextToken());
            if (!validateSubmit(submit, answer, "Why Wrong!!!")) return;
        }
        System.out.println("Accepted");
    }

    static boolean validateSubmit(int submit, int answer, String message) {
        if (submit != answer) {
            System.out.println(message);
            return false;
        }
        return true;
    }

}