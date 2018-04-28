import java.util.*;
import java.io.*;

/**
 * A
 */
public class A {
    public static boolean isLegal(long number) {
        if (number % 9 == 0) {
            return false;
        }
        long tmp = number;
        while (tmp > 0) {
            if (tmp % 10 == 9) {
                return false;
            }
            tmp = tmp / 10;
        }
        return true;
    }

    public static long f(long x) {
        long sum = 0;
        for (long i = (x - x % 10); i <= x; i++) {
            if (isLegal(i)) {
                sum ++;
            }
        }
        x /= 10;
        long tmpSum = 0;
        long power9 = 9;
        while (x > 0) {
            tmpSum += power9 * (x % 10);
            power9 *= 9;
            x /= 10;
        }
        sum += 8 * tmpSum / 9 ;

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int t = Integer.parseInt(line.trim());
            for (int i = 1; i <= t; i++) {
                line = in.readLine();
                long f = Long.parseLong(line.split(" ")[0]);
                long l = Long.parseLong(line.split(" ")[1].trim());

                System.out.printf("Case #%d: %d\n", i, f(l) - f(f) + 1);
            }            
        }
    }
}