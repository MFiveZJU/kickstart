import java.util.*;
import java.io.*;

/**
 * CSort
 */

public class CSort {

    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            System.out.printf("Case #%d:", i+1);
            int n = Integer.parseInt(in.readLine());
            HashMap<String, String> content = new HashMap<String, String>();
            HashMap<String, Integer> count = new HashMap<String, Integer>();
            for (int j = 0; j < n; j++) {
                String begin = in.readLine().trim();
                String end = in.readLine().trim();
                content.put(begin, end);
                count.put(begin, count.getOrDefault(begin, 0)+1);
                count.put(end, count.getOrDefault(end, 0) + 1);
            }
            for(Map.Entry<String, Integer> entry : count.entrySet()){
                if (entry.getValue() == 1) {
                    String tmp = entry.getKey();
                    while (content.containsKey(tmp)) {
                        System.out.printf(" %s-%s", tmp, content.get(tmp));
                        tmp = content.get(tmp);
                    }       
                }
            }
            System.out.println();
        }
    }
}