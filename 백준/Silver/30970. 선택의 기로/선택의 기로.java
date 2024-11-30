import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Miniature> priceQue = new PriorityQueue<>(new MiniaturePriceComparator());
        PriorityQueue<Miniature> qualityQue = new PriorityQueue<>(new MiniatureQualityComparator());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int quality = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            Miniature miniature = new Miniature(quality, price);
            priceQue.add(miniature);
            qualityQue.add(miniature);
        }

        appendAnswer(2, sb, qualityQue);
        sb.append("\n");
        appendAnswer(2, sb, priceQue);
        System.out.println(sb);
    }

    static void appendAnswer(int pollCount, StringBuilder sb, Queue<Miniature> que) {
        for (int i = 0; i < pollCount; i++) {
            Miniature jewel = que.poll();
            sb.append(jewel.quality).append(" ").append(jewel.price).append(" ");
        }
    }
}

class Miniature {
    int quality, price;

    public Miniature(int quality, int price) {
        this.quality = quality;
        this.price = price;
    }
}

class MiniatureQualityComparator implements Comparator<Miniature> {
    @Override
    public int compare(Miniature o1, Miniature o2) {
        return o1.quality != o2.quality ? o2.quality - o1.quality : o1.price - o2.price;
    }
}

class MiniaturePriceComparator implements Comparator<Miniature> {
    @Override
    public int compare(Miniature o1, Miniature o2) {
        return o1.price != o2.price ?  o1.price - o2.price : o2.quality - o1.quality;
    }
}

