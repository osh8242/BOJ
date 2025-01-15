import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static final int[][] records = {
            {12, 1600},
            {11, 894},
            {11, 1327},
            {10, 1311},
            {9, 1004},
            {9, 1178},
            {9, 1357},
            {8, 837},
            {7, 1055},
            {6, 556},
            {6, 773}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine()) - 1;
        System.out.println(records[index][0] + " " + records[index][1]);
    }
}
