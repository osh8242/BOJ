import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String dance;
        while ((dance = br.readLine()) != null && !dance.isEmpty()) {
            String[] tokens = dance.split(" ");
            boolean[] valid = new boolean[6];
            int rule1 = checkRuleOne(tokens);
            valid[1] = rule1 == -1;
            valid[2] = checkRuleTwo(tokens);
            valid[3] = checkRuleThree(tokens);
            valid[4] = checkRuleFour(tokens);
            valid[5] = checkRuleFive(tokens);

            List<Integer> errors = new ArrayList<>();
            for (int i = 1; i <= 5; i++) if (!valid[i]) errors.add(i);

            sb.append("form ");
            if (errors.isEmpty()) {
                sb.append("ok: ").append(dance).append("\n");
            } else {
                appendErrors(sb, errors);
                sb.append(": ");
                if (errors.get(0) == 1) {
                    appendDanceForRuleOne(sb, tokens, rule1);
                } else sb.append(dance);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static int checkRuleOne(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("dip")) continue;
            if (!(i > 0 && tokens[i - 1].equals("jiggle"))
                    && !(i > 1 && tokens[i - 2].equals("jiggle"))
                    && !(i < tokens.length - 1 && tokens[i + 1].equals("twirl"))) return i;
        }
        return -1;
    }

    static boolean checkRuleTwo(String[] tokens) {
        return tokens[tokens.length - 1].equals("clap")
                && tokens[tokens.length - 2].equals("stomp")
                && tokens[tokens.length - 3].equals("clap");
    }

    static boolean checkRuleThree(String[] tokens) {
        boolean containTwirl = false;
        boolean containHop = false;
        for (String token : tokens) {
            if (token.equals("twirl") && !containTwirl) containTwirl = true;
            if (token.equals("hop") && !containHop) containHop = true;
            if (containTwirl && containHop) return true;
        }
        return !containTwirl;
    }

    static boolean checkRuleFour(String[] tokens) {
        return !tokens[0].equals("jiggle");
    }

    static boolean checkRuleFive(String[] tokens) {
        for (String token : tokens) {
            if (token.equals("dip")) return true;
        }
        return false;
    }

    static void appendErrors(StringBuilder sb, List<Integer> errors) {
        sb.append("error");
        if (errors.size() > 1) sb.append("s");
        sb.append(" ");
        sb.append(errors.get(0));
        if (errors.size() > 2) {
            for (int i = 1; i < errors.size() - 1; i++) {
                sb.append(", ").append(errors.get(i));
            }
        }
        if (errors.size() > 1) sb.append(" and ").append(errors.get(errors.size() - 1));
    }

    static void appendDanceForRuleOne(StringBuilder sb, String[] tokens, int errIdx) {
        for (int i = 0; i < tokens.length; i++) {
            if (errIdx == i) sb.append(tokens[i].toUpperCase());
            else sb.append(tokens[i]);
            if (i != tokens.length - 1) sb.append(" ");
        }
    }


}