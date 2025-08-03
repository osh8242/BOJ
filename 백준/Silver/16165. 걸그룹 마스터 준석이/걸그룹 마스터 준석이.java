import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nm.nextToken()), M = Integer.parseInt(nm.nextToken());
        Map<String, List<String>> teamMembers = new HashMap<>();
        Map<String, String> memberTeam = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String team = br.readLine().trim();
            int cnt = Integer.parseInt(br.readLine().trim());
            List<String> list = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                String mem = br.readLine().trim();
                list.add(mem);
                memberTeam.put(mem, team);
            }
            Collections.sort(list);
            teamMembers.put(team, list);
        }
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String q = br.readLine().trim();
            int type = Integer.parseInt(br.readLine().trim());
            if (type == 0) {
                for (String mem : teamMembers.get(q)) {
                    sb.append(mem).append('\n');
                }
            } else {
                sb.append(memberTeam.get(q)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
