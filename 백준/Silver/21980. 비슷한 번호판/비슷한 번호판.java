import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int count = 0;
            br.readLine();
            Map<Plate, Integer> plates = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                Plate plate = new Plate(st.nextToken());
                plates.put(plate, plates.getOrDefault(plate, 0) + 1);
            }
            for (Integer value : plates.values()) {
                count += value * (value - 1) / 2;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}

class Plate {
    String hashStr;
    int upperCaseCount = 0;

    public Plate(String plate) {
        char[] chars = plate.toCharArray();
        int[] charCount = new int[26];
        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                upperCaseCount++;
                charCount[c - 'A']++;
            } else charCount[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(upperCaseCount);
        for (int i = 0 ; i < charCount.length ; i++) {
            if (charCount[i] == 0) continue;
            sb.append((char) (i + 'A')).append(charCount[i]);
        }
        hashStr = sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate plate = (Plate) o;
        return upperCaseCount == plate.upperCaseCount && Objects.equals(hashStr, plate.hashStr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upperCaseCount, hashStr);
    }
}