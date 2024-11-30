import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Jewel> priceQue = new PriorityQueue<>(new JewelPriceComparator());
        PriorityQueue<Jewel> qualityQue = new PriorityQueue<>(new JewelQualityComparator());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int quality = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            Jewel jewel = new Jewel(quality, price);
            priceQue.add(jewel);
            qualityQue.add(jewel);
        }

        appendAnswer(2, sb, qualityQue);
        sb.append("\n");
        appendAnswer(2, sb, priceQue);
        System.out.println(sb);
    }

    static void appendAnswer(int pollCount, StringBuilder sb, Queue<Jewel> que) {
        for (int i = 0; i < pollCount; i++) {
            Jewel jewel = que.poll();
            sb.append(jewel.quality).append(" ").append(jewel.price).append(" ");
        }
    }
}

class Jewel implements Comparable<Jewel> {
    int quality, price;

    public Jewel(int quality, int price) {
        this.quality = quality;
        this.price = price;
    }

    @Override
    public int compareTo(Jewel o) {
        return this.price - o.price;
    }
}

class JewelQualityComparator implements Comparator<Jewel> {
    @Override
    public int compare(Jewel o1, Jewel o2) {
        return o1.quality != o2.quality ? o2.quality - o1.quality : o1.price - o2.price;
    }
}

class JewelPriceComparator implements Comparator<Jewel> {
    @Override
    public int compare(Jewel o1, Jewel o2) {
        return o1.price != o2.price ?  o1.price - o2.price : o2.quality - o1.quality;
    }
}

