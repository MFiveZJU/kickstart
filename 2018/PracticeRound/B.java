import java.io.*;
import java.util.*;

public class googolString {
    private static boolean isone(long l, long k) {
        if (k == (l - 1) / 2)
            return false;
        else if (k < (l - 1) / 2)
            return isone((l - 1) / 2, k);
        else
            return !isone(l / 2, l - k - 1);
    }

    private static void solve(long K) {
        long an = 0;
        while (an <= K)
            an = an * 2 + 1;
        System.out.println(isone(an, K) ? "1" : "0");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int count = Integer.parseInt(line);
        for(int i = 0; i < count; i++){
            System.out.printf("Case #%d: ", i+1);
            line = in.readLine();
            solve(Long.parseLong(line)-1);
        }
    }
}