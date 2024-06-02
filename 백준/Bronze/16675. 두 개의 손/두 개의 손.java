import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        String ML = inputs[0];
        String MR = inputs[1];
        String TL = inputs[2];
        String TR = inputs[3];

        boolean minseongWins = canWin(ML, MR, TL, TR);
        boolean taegyeongWins = canWin(TL, TR, ML, MR);

        if (minseongWins) {
            sb.append("MS");
        } else if (taegyeongWins) {
            sb.append("TK");
        } else {
            sb.append("?");
        }

        System.out.println(sb);
    }

    public static boolean canWin(String leftHand1, String rightHand1, String leftHand2, String rightHand2) {
        return (beats(leftHand1, leftHand2) && beats(leftHand1, rightHand2)) ||
                (beats(rightHand1, leftHand2) && beats(rightHand1, rightHand2));
    }

    public static boolean beats(String hand1, String hand2) {
        return (hand1.equals("S") && hand2.equals("P")) ||
                (hand1.equals("R") && hand2.equals("S")) ||
                (hand1.equals("P") && hand2.equals("R"));
    }
}
