import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static Node[][] map;
    static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new Node[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new Node();
            }
        }
        char[] chars = br.readLine().toCharArray();
        Position current = new Position(0, 0);
        for (char cmd : chars) {
            Position next = Position.getNextPositionByCmd(current, cmd);
            if(!inBound(next)) continue;
            recordMovement(current, cmd);
            recordMovement(next, cmd);
            current = next;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(getAsciiCode(map[i][j]));
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void recordMovement(Position p, char cmd) {
        switch (cmd) {
            case 'U', 'D' -> map[p.row][p.col].vertical = true;
            case 'L', 'R' -> map[p.row][p.col].horizontal = true;
        }
    }

    static boolean inBound(Position p) {
        return p.row >= 0 && p.row < N && p.col >= 0 && p.col < N;
    }

    static char getAsciiCode(Node n) {
        return (char) (n.vertical ? (n.horizontal ? 43 : 124) : (n.horizontal ? 45 : 46));
    }

    static class Node {
        boolean vertical;
        boolean horizontal;

        public Node() {
            this.vertical = false;
            this.horizontal = false;
        }
    }

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public static Position getNextPositionByCmd(Position p, char cmd) {
            return switch (cmd) {
                case 'U' -> new Position(p.row - 1, p.col);
                case 'D' -> new Position(p.row + 1, p.col);
                case 'L' -> new Position(p.row, p.col - 1);
                case 'R' -> new Position(p.row, p.col + 1);
                default -> throw new IllegalArgumentException();
            };
        }
    }

}
