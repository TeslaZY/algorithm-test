package fr;

/**
 * @author Tesla.Z
 * @version 10.0
 * Created by Tesla.Z on 2020/9/17
 */
import java.io.*;
import java.math.BigInteger;

public class Prime {

    public static long[][] bases = new long[][] {
            new long[] { 2, 3 },
            new long[] { 2, 299417 },
            new long[] { 2, 7, 61 },
            new long[] { 15, 176006322, 4221622697L },
            new long[] { 2, 2570940, 211991001, 3749873356L },
            new long[] { 2, 2570940, 880937, 610386380, 4130785767L },
            new long[] { 2, 325, 9375, 28178, 450775, 9780504, 1795265022 }
    };

    public static boolean composite (long n, long[] bases) {
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger nMinusOne = bigN.subtract(BigInteger.ONE);
        BigInteger bidD = nMinusOne; // d
        int shiftCount = bidD.getLowestSetBit();// t
        bidD = bidD.shiftRight(shiftCount);//

        for (long base: bases) {
            BigInteger bigBase = BigInteger.valueOf(base);// base
            int i = 0;
            BigInteger z = bigBase.modPow(bidD, bigN); //z= a^d mod n
            while (!((i == 0 && z.equals(BigInteger.ONE)) || z.equals(nMinusOne))) {
                if (i > 0 && z.equals(BigInteger.ONE) || ++i == shiftCount)
                    return false;
                z = z.modPow(BigInteger.valueOf(2), bigN);
            }
        }
        return true;
    }

    public static boolean isPrime (long n) {
        if (n == 2) {
            return true;
        }
        if (n < 2 || (n & 1) == 0) {
            return false;
        }
        if (n < 8) {
            return true;
        }
        int x = 6;
        if (n < 1373653) {
            x = 0;
        } else if (n < 19471033) {
            x = 1;
        } else if (n < 4759123141L) {
            x = 2;
        } else if (n < 154639673381L) {
            x = 3;
        } else if (n < 47636622961201L) {
            x = 4;
        } else if (n < 3770579582154547L) {
            x = 5;
        }
        return composite(n, bases[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = "N\n";
        String Y = "Y\n";
        String input = in.readLine();
        while (input != null && !"".equals(input)) {
            long value = Long.valueOf(input);
            out.write(isPrime(value) ? Y : N);
            input = in.readLine();
        }
        out.flush();
    }
}
