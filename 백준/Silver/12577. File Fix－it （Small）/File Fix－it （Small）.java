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
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Directory root = new Directory(null, "");
            int answer = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), "/");
                Directory parent = root;
                while (st.hasMoreTokens()) {
                    Directory dir = new Directory(parent, st.nextToken());
                    if (!parent.children.containsKey(dir.name)) parent.children.put(dir.name, dir);
                    parent = parent.children.get(dir.name);
                }
            }
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine(), "/");
                Directory parent = root;
                while (st.hasMoreTokens()) {
                    Directory dir = new Directory(parent, st.nextToken());
                    if (!parent.children.containsKey(dir.name)) {
                        parent.children.put(dir.name, dir);
                        answer++;
                    }
                    parent = parent.children.get(dir.name);
                }
            }
            sb.append("Case #").append(i).append(": ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static class Directory {
        Directory parent;
        String name;
        Map<String, Directory> children;

        public Directory(Directory parent, String name) {
            this.parent = parent;
            this.name = name;
            this.children = new HashMap<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Directory directory = (Directory) o;
            return Objects.equals(parent, directory.parent) && Objects.equals(name, directory.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(parent, name);
        }
    }
}

