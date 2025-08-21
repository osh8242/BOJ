import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) continue;
            int N;
            try {
                N = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                continue;
            }
            Map<String,String> map = new HashMap<>();
            int readLang = 0;
            while (readLang < N) {
                line = br.readLine();
                if (line == null) break;
                line = line.trim();
                if (line.length() == 0) continue;
                String[] parts = line.split("\\s+");
                if (parts.length >= 1) {
                    String lang = parts[0];
                    for (int i = 1; i < parts.length; i++) {
                        map.put(parts[i].toLowerCase(), lang);
                    }
                    readLang++;
                }
            }
            String sampleLine = br.readLine();
            if (sampleLine == null) continue;
            if (sampleLine.trim().length() != 0) {
                processSampleLine(sampleLine, map);
            }
            Pattern p = Pattern.compile("[A-Za-z'-]+");
            while ((line = br.readLine()) != null) {
                if (line.length() == 0) {
                    continue;
                }
                processSampleLine(line, map);
            }
        }
    }

    static void processSampleLine(String line, Map<String,String> map) {
        Pattern p = Pattern.compile("[A-Za-z'-]+");
        Matcher m = p.matcher(line);
        while (m.find()) {
            String tok = m.group().toLowerCase();
            if (map.containsKey(tok)) {
                System.out.println(map.get(tok));
                return;
            }
        }
    }
}
