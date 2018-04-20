import java.util.*;
import java.io.*;

public class GBus {
    public static int findSmaller(int[] arr, int num) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] >= num) 
                return i;
        
        return arr.length;
    } 
    
    public static int findNBigger(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > num)
                return i;

        return arr.length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = in.readLine();
        int t = Integer.parseInt(line);
        for(int i = 0; i < t; i++){
            line = in.readLine();
            int n = Integer.parseInt(line);
            int[] begins = new int[n];
            int[] ends = new int[n];

            line = in.readLine();
            String[] parts = line.trim().split(" ");
            for (int j = 0; j < n; j++) {
                begins[j] = Integer.parseInt(parts[2*j]);
                ends[j] = Integer.parseInt(parts[2*j+1]);
            }
            Arrays.sort(begins);
            Arrays.sort(ends);

            line = in.readLine();
            int p = Integer.parseInt(line);
            System.out.printf("Case #%d:", i+1);
            for(int k = 0; k < p; k++){
                line = in.readLine();
                int tmp = Integer.parseInt(line);
                int lo = findNBigger(begins, tmp);
                int hi = findSmaller(ends, tmp);
                System.out.printf(" %d", lo - hi);
            }
            System.out.println();
            line = in.readLine();
        }
    }
}