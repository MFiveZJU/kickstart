import java.util.*;
import java.io.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int t = Integer.parseInt(line.trim());
            for (int i = 0; i < t; i++) {
                line = in.readLine().trim();
                int n = Integer.parseInt(line.split(" ")[0]);
                int k = Integer.parseInt(line.split(" ")[1]);
                line = in.readLine().trim();
                String[] strVs = line.split(" ");
                long[] vs = new long[n];
                for (int ii = 0; ii < strVs.length; ii++) {
                    vs[ii] = Long.parseLong(strVs[ii]);
                }
                Arrays.sort(vs);
                long[] prefixVsSum = new long[n + 1];
                prefixVsSum[0] = 0;
                for (int ii = 1; ii <= n; ii++) {
                    prefixVsSum[ii] = vs[ii - 1] + prefixVsSum[ii - 1];
                }
                double lastE = 1.0 * prefixVsSum[n] / n;
                
                for (int ii = 1; ii <= k; ii++) {
                    int pointer = 0;
                    while(pointer < n && vs[pointer] <= lastE)
                        pointer++;
                    lastE = ((lastE * pointer) + (prefixVsSum[n] - prefixVsSum[pointer])) / n;
                }
                System.out.printf("Case #%d: %.6f\n", i + 1, lastE);
            }
        }
    }
}