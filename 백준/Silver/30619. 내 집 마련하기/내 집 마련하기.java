import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] people = new int[N + 1];
        int[] houses = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            houses[people[i]] = i;
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            int[] copiedPeople = Arrays.copyOf(people, N + 1);
            int[] copiedHouses = Arrays.copyOf(houses, N + 1);

            List<Integer> subPeople = new ArrayList<>();
            List<Integer> subHouses = new ArrayList<>();

            for (int person = L; person <= R; person++) {
                subPeople.add(person);
                subHouses.add(copiedHouses[person]);
            }

            Collections.sort(subPeople);
            Collections.sort(subHouses);

            for (int i = 0; i < subPeople.size(); i++) {
                copiedPeople[subHouses.get(i)] = subPeople.get(i);
            }

            for (int i = 1; i <= N; i++) {
                sb.append(copiedPeople[i]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
