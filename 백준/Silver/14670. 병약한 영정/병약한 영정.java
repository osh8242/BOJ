import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입출력 객체 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 약과 효능 입력받기 + HashMap 저장
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> drugMap = new HashMap<>();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int effect = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            drugMap.put(effect, id);
        }

        // 증상 입력받기 + 증상에 맞는 약찾기 + 출력문자열 설정
        int R = Integer.parseInt(br.readLine());
        while (R-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> drugList = new ArrayList<>();
            boolean canBeCured = true;
            while (st.hasMoreTokens()) {
                int symptom = Integer.parseInt(st.nextToken());
                if (!drugMap.containsKey(symptom)) {
                    canBeCured = false;
                    break;
                } else drugList.add(drugMap.get(symptom));
            }
            if (canBeCured) for (Integer i : drugList) sb.append(i).append(" ");
            else sb.append("YOU DIED");
            sb.append("\n");
        }

        // 출력
        bw.write(sb.toString());
        bw.flush();
    }

}
