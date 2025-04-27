import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[50];
        for (int i = 0; i < 50; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        int myScore = Integer.parseInt(br.readLine().trim());

        int rank = 0;
        for (int i = 0; i < 50; i++) {
            if (scores[i] == myScore) {
                rank = i + 1;
                break;
            }
        }

        String grade;
        if (rank <= 5) grade = "A+";
        else if (rank <= 15) grade = "A0";
        else if (rank <= 30) grade = "B+";
        else if (rank <= 35) grade = "B0";
        else if (rank <= 45) grade = "C+";
        else if (rank <= 48) grade = "C0";
        else grade = "F";

        System.out.println(grade);
    }
}
