import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static final Map<String, String> nameMap = new HashMap<String, String>();

    static {
        nameMap.put("NLCS", "North London Collegiate School");
        nameMap.put("BHA", "Branksome Hall Asia");
        nameMap.put("KIS", "Korea International School");
        nameMap.put("SJA", "St. Johnsbury Academy");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(nameMap.get(br.readLine()));
        bw.flush();
    }

}
