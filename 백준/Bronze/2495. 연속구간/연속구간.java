import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Character> arrayList;
    static char[] chars;

    public static void main(String[] args) throws IOException {
        for (int test_case = 1; test_case <= 3; test_case++) {
            arrayList = new ArrayList<>();
            chars = br.readLine().toCharArray();
            char prevChar = chars[0];
            arrayList.add(chars[0]);
            int index = 0;
            for (int i = 1; i < chars.length; i++) {
                char ch = chars[i];
                if (prevChar == ch) {
                    if (index == arrayList.size() - 1) {
                        arrayList.add(ch);
                    } else arrayList.set(index + 1, ch);
                    index++;
                } else {
                    for (int j = 0; j < arrayList.size(); j++) {
                        if (arrayList.get(j) != ch) {
                            prevChar = ch;
                            arrayList.set(j, ch);
                            index = j;
                            break;
                        }
                    }
                }
            }
            sb.append(arrayList.size() == 1 ? 1 : arrayList.size()).append("\n");
        }
        System.out.println(sb);
    }
}
