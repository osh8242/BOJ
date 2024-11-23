import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] table = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            table[i] = br.readLine().toCharArray();
        }
        
        int low = 0, high = R - 1, maxRowsToRemove = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canRemoveRows(table, mid, C)) {
                maxRowsToRemove = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        System.out.println(maxRowsToRemove);
    }
    
    static boolean canRemoveRows(char[][] table, int rowsToRemove, int C) {
        Set<String> seen = new HashSet<>();
        for (int col = 0; col < C; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = rowsToRemove; row < table.length; row++) {
                sb.append(table[row][col]);
            }
            String colString = sb.toString();
            if (seen.contains(colString)) {
                return false;
            }
            seen.add(colString);
        }
        return true;
    }
}
