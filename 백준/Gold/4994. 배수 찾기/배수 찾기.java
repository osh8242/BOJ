import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            sb.append(findSmallestMultiple(n)).append("\n");
        }

        System.out.print(sb);
    }

    static String findSmallestMultiple(int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(new Node("1", 1 % n));
        visited[1 % n] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.remainder == 0) {
                return current.value;
            }

            String appendZero = current.value + "0";
            int remainderZero = (current.remainder * 10) % n;
            if (!visited[remainderZero]) {
                visited[remainderZero] = true;
                queue.add(new Node(appendZero, remainderZero));
            }

            String appendOne = current.value + "1";
            int remainderOne = (current.remainder * 10 + 1) % n;
            if (!visited[remainderOne]) {
                visited[remainderOne] = true;
                queue.add(new Node(appendOne, remainderOne));
            }
        }

        return null;
    }

    // 큐에서 사용할 Node 클래스
    static class Node {
        String value;
        int remainder;

        Node(String value, int remainder) {
            this.value = value;
            this.remainder = remainder;
        }
    }
}
