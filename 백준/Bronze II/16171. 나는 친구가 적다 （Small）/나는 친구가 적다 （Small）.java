import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        List<Character> list = new ArrayList<>();
        for (char ch : input) {
            if (ch > '9') list.add(ch);
        }
        char[] listCh = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            listCh[i] = list.get(i);
        }
        String str = new String(listCh);
        boolean isExist = str.contains(br.readLine());
        System.out.println(isExist ? 1 : 0);
    }
}
