import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Dot {
        int dps, len;
        Dot(int d, int l) { dps = d; len = l; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        List<Dot> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int d = Integer.parseInt(parts[0]);
            int l = Integer.parseInt(parts[1]);
            list.add(new Dot(d, l));
        }
        // 1) DPS 내림차순 정렬
        list.sort((a, b) -> b.dps - a.dps);
        // 2) 컷오프 DPS
        int cutoff = list.get(M - 1).dps;
        // 3) DPS > cutoff, DPS == cutoff 분리
        List<Dot> high = new ArrayList<>();
        List<Dot> eq = new ArrayList<>();
        for (Dot dot : list) {
            if (dot.dps > cutoff) high.add(dot);
            else if (dot.dps == cutoff) eq.add(dot);
        }
        int need = M - high.size();  // eq 에서 이만큼 골라야 함
        // 4) eq 를 길이 내림차순 정렬하여 상위 need개 선택
        eq.sort((a, b) -> b.len - a.len);
        List<Dot> chosen = new ArrayList<>(high);
        for (int i = 0; i < need; i++) {
            chosen.add(eq.get(i));
        }
        // 5) 결과 계산
        int totalDPS = 0;
        int duration = Integer.MAX_VALUE;
        for (Dot dot : chosen) {
            totalDPS += dot.dps;
            duration = Math.min(duration, dot.len);
        }
        System.out.println(totalDPS + " " + duration);
    }
}
