import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Double> priceMap = new HashMap<>();
        priceMap.put("Paper", 57.99);
        priceMap.put("Printer", 120.50);
        priceMap.put("Planners", 31.25);
        priceMap.put("Binders", 22.50);
        priceMap.put("Calendar", 10.95);
        priceMap.put("Notebooks", 11.20);
        priceMap.put("Ink", 66.95);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        double totalCost = 0.0;
        
        while (!(input = br.readLine()).equals("EOI")) {
            if (priceMap.containsKey(input)) {
                totalCost += priceMap.get(input);
            }
        }
        
        System.out.println(String.format("$%.2f", totalCost));
    }
}
