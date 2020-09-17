package fr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;


/**
 * @author Tesla.Z
 * @version 10.0
 * Created by Tesla.Z on 2020/9/15
 */
public class IsPrimeNumber {
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

    public static String isPrimeO_N_6(long n) {
        if (n == 1) return "N";
        if (n == 2 || n == 3) return "Y";
        if (n % 6 != 1 && n % 6 != 5) return "N";
        for (int i = 5; i * i <= n; i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return "N";
        return "Y";
    }

    public static String isPrimeO_N(long n) {
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0)
                return "N";
        return "Y";
    }


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
        BigInteger nn = BigInteger.valueOf(n);
        BigInteger thisMinusOne = nn.subtract(BigInteger.ONE);
        BigInteger m = thisMinusOne;
        int a = m.getLowestSetBit();
        m = m.shiftRight(a);

        for (long base: bases) {
            // Generate a uniform random on (1, this)
            BigInteger b = BigInteger.valueOf(base);

            int j = 0;
            BigInteger z = b.modPow(m, nn);
            while (!((j == 0 && z.equals(BigInteger.ONE)) || z.equals(thisMinusOne))) {
                if (j > 0 && z.equals(BigInteger.ONE) || ++j == a)
                    return false;
                z = z.modPow(BigInteger.valueOf(2), nn);
            }
        }
        return true;
    }

    public static boolean isPrime (long n) {
        if (n == 2) {
            return true;
        }
        if (n < 2 || n % 2 == 0) {
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

    public String isPrimeMiller(long n) {
        long[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        String N = "N\n";
        String Y = "Y\n";
        if (n <= 1) return N;
        if (n == 2) return Y;
        long s = 0, t = n - 1;
        while (t % 2 == 0) {
            ++s;
            t >>= 1;
        }// get n-1=2^s * t
        BigInteger bV,mV,nV,kV;
        nV = BigInteger.valueOf(n);
        for (int i = 0; i < prime.length && prime[i] < n; ++i) {
            long p = t;
            bV = BigInteger.valueOf(1);
            mV = BigInteger.valueOf(prime[i]);
            while (p != 0) { //get b=a^t
                if ((p&1) != 0) {
                    bV = bV.multiply(mV).remainder(nV);
                }
                mV = mV.multiply(mV).remainder(nV) ;
                p >>= 1;
            }
            if (bV.longValue() == 1) continue;
            for (int j = 1; j <= s; ++j) { // double check
                kV = bV.multiply(bV).remainder(nV);
                if (kV.longValue() == 1 && bV.longValue() != n - 1 && bV.longValue() != 1) return N;
                bV = kV;
            }
            if (bV.longValue() != 1) return N;
        }
        bV = null;
        kV = null;
        mV = null;
        return Y;
    }
}
