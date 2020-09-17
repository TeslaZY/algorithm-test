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
        String input = in.readLine();
        while (input != null && !"".equals(input)) {
//            long start = System.currentTimeMillis();
            long value = Long.valueOf(input);
            out.write(isPrime3(value));
            input = in.readLine();
//            long end = System.currentTimeMillis();
//            System.out.println(end - start);
        }
        out.flush();
    }

//    public static String isPrime1(long n) {
//        if (n == 1) return "N";
//        if (n == 2 || n == 3) return "Y";
//        if (n % 6 != 1 && n % 6 != 5) return "N";
//        for (int i = 5; i * i <= n; i += 6)
//            if (n % i == 0 || n % (i + 2) == 0) return "N";
//        return "Y";
//    }
//
//    public static String isPrime2(long n) {
//        for (long i = 2; i * i <= n; i++)
//            if (n % i == 0)
//                return "N";
//        return "Y";
//    }

    static long[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static String N = "N\n";
    static String Y = "Y\n";

    public static String isPrime3(long n) {
        if (n <= 1) return "N";
        if (n == 2) return "Y";
        long s = 0, t = n - 1;
        while (t % 2 == 0) {
            ++s;
            t >>= 1;
        }// get n-1=2^s * t
        BigInteger bV,mV,nV,kV;
        long base,b,m,p;
        for (int i = 0; i < prime.length && prime[i] < n; ++i) {
            bV = null;
            mV = null;
            nV = null;
            kV = null;
            base = prime[i];
            b = 1; m = base; p = t;
            bV = BigInteger.valueOf(b);
            mV = BigInteger.valueOf(m);
            nV = BigInteger.valueOf(n);

            while (p != 0) { //get b=a^t
                if (p % 2 != 0) {
                    bV = bV.multiply(mV).mod(nV);
                }
                mV = mV.multiply(mV).mod(nV) ;
                p >>= 1;
            }
            if (bV.longValue() == 1) continue;
            for (int j = 1; j <= s; ++j) { // double check
                kV = bV.multiply(bV).mod(nV);
                if (kV.longValue() == 1 && bV.longValue() != n - 1 && bV.longValue() != 1) return N;
                bV = kV;
            }
            if (bV.longValue() != 1) return N;
        }
        return Y;
    }
}
