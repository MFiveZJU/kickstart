import java.util.*;
import java.io.*;

/**
 * Main
 */
public class Main {
    public static long findPlus(long n) {
        String digits = Long.toString(n);
        String retDigits = "";
        boolean hasOdd = false;
        for (int i = 0; i < digits.length(); i++) {
            if (hasOdd) {
                retDigits = retDigits + "0";
            }
            else{
                int tmp = Character.getNumericValue(digits.charAt(i));
                if (tmp % 2 == 1) {
                    hasOdd = true;
                    if (tmp == 9) {
                        retDigits = retDigits + "0";
                        int ii = i - 1;
                        boolean findLeft = false;
                        while (ii >= 0) {
                            if (Character.getNumericValue(digits.charAt(ii)) == 8) {
                                retDigits = retDigits.substring(0, ii) + "0" + retDigits.substring(ii + 1, i + 1);
                            }
                            else{
                                findLeft = true;
                                retDigits = retDigits.substring(0, ii) + Long.toString(Character.getNumericValue(digits.charAt(ii)) + 2) + retDigits.substring(ii + 1, i + 1);
                                break;
                            }
                            ii--;
                        }
                        if (!findLeft) {
                            retDigits = "2" + retDigits;
                        }
                    }
                    else{
                        retDigits = retDigits + Long.toString(tmp + 1);
                    }
                } else {
                    retDigits = retDigits + digits.charAt(i);
                }
            }
        }

        return Long.parseLong(retDigits);
    }

    public static long findMinus(long n) {
        String digits = Long.toString(n);
        String retDigits = "";
        boolean hasOdd = false;
        for (int i = 0; i < digits.length(); i++) {
            if (hasOdd) {
                retDigits = retDigits + "8";
            }
            else{
                int tmp = Character.getNumericValue(digits.charAt(i));
                if (tmp % 2 == 1) {
                    hasOdd = true;
                    retDigits = retDigits + Long.toString(tmp - 1);
                }
                else{
                    retDigits = retDigits + digits.charAt(i);
                }
            }
        }

        return Long.parseLong(retDigits);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            long t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                long n = in.nextLong();
                long p = findPlus(n);
                long m = findMinus(n);
                System.out.printf("Case #%d: %d\n", i, Math.min(p - n, n - m));
                // System.out.printf("%d - %d", p, m);
            }
        }
    }
}