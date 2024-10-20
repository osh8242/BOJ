import java.io.*;
import java.util.*;

class Main {

    static final String NOT_FIT = "Item does not fit.";
    static final List<Box> boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boxes.add(new Box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(boxes);

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Item item = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Box box = findFittingBox(item);
            sb.append(box == null ? NOT_FIT : box.volume).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static Box findFittingBox(Item item) {
        // Iterate over each box (smallest volume first)
        for (Box box : boxes) {
            if (box.isPackable(item)) return box;
        }
        // No box fits
        return null;
    }

}


class Item {
    int length;
    int width;
    int height;
    int[] order = new int[3];

    public Item(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        order[0] = length;
        order[1] = width;
        order[2] = height;
        Arrays.sort(order);
    }
}

class Box extends Item implements Comparable<Box> {
    int volume;

    public Box(int length, int width, int height) {
        super(length, width, height);
        this.volume = length * width * height;
    }

    boolean isPackable(Item item) {
        return this.order[2] >= item.order[2] && this.order[1] >= item.order[1] && this.order[0] >= item.order[0];
    }

    @Override
    public int compareTo(Box o) {
        return this.volume - o.volume;
    }
}