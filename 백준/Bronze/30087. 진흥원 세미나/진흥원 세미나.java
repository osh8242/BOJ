import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        map.put("Algorithm", "204");
        map.put("DataAnalysis", "207");
        map.put("ArtificialIntelligence", "302");
        map.put("CyberSecurity", "B101");
        map.put("Network", "303");
        map.put("Startup", "501");
        map.put("TestStrategy", "105");

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) sb.append(map.get(br.readLine())).append('\n');

        bw.write(sb.toString());
        bw.flush();
    }


}