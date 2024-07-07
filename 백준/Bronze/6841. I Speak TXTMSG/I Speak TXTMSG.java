import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> translationMap = new HashMap<>();
        translationMap.put("CU", "see you");
        translationMap.put(":-)", "I’m happy");
        translationMap.put(":-(", "I’m unhappy");
        translationMap.put(";-)", "wink");
        translationMap.put(":-P", "stick out my tongue");
        translationMap.put("(~.~)", "sleepy");
        translationMap.put("TA", "totally awesome");
        translationMap.put("CCC", "Canadian Computing Competition");
        translationMap.put("CUZ", "because");
        translationMap.put("TY", "thank-you");
        translationMap.put("YW", "you’re welcome");
        translationMap.put("TTYL", "talk to you later");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while (!(input = br.readLine()).equals("TTYL")) {
            if (translationMap.containsKey(input)) {
                bw.write(translationMap.get(input));
            } else {
                bw.write(input);
            }
            bw.newLine();
            bw.flush();
        }

        bw.write(translationMap.get("TTYL"));
        bw.newLine();
        bw.flush();
    }
}
