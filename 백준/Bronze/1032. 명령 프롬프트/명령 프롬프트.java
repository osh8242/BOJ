import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Integer length = null;

    static class File {
        private String name;

        public File(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<File> files = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String fileName = br.readLine();
            if (length == null) length = fileName.length();
            files.add(new File(fileName));
        }
        for (int i = 0; i < length; i++) {
            boolean isAllSame = true;
            for (int j = 0; j < N - 1; j++) {
                if (files.get(j).name.charAt(i) != files.get(j + 1).name.charAt(i)) {
                    isAllSame = false;
                    break;
                }
            }
            sb.append(isAllSame ? files.get(0).name.charAt(i) : '?');
        }
        System.out.println(sb);
    }
}
