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
    static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static BigInteger bV,mV,nV,kV;
    static String N = "N\n";
    static String Y = "Y\n";
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = in.readLine();
        long value;
        while (input != null && !"".equals(input)) {
//            long start = System.currentTimeMillis();
            if(input.length()>6){
                value = Long.valueOf(input);
                out.write( isPrime3(value) ? Y : N);
            }else {
                out.write( isPrime4(Integer.valueOf(input)) ? Y : N);
            }
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

    public static boolean isPrime3(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        long s = 0, t = n - 1;
        while (t % 2 == 0) {
            ++s;
            t >>= 1;
        }// get n-1=2^s * t
        nV = BigInteger.valueOf(n);
        long base,b,m,p;
        for (int i = 0; i < prime.length && prime[i] < n; ++i) {
            base = prime[i];
            b = 1; m = base; p = t;
            bV = BigInteger.valueOf(b);
            mV = BigInteger.valueOf(m);

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
                if (kV.longValue() == 1 && bV.longValue() != n - 1 && bV.longValue() != 1) return false;
                bV = kV;
            }
            if (bV.longValue() != 1) return false;
        }
        return true;
    }

    static boolean isPrime4(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        int s = 0, t = n - 1;
        while (t % 2 == 0) {
            ++s;
            t >>= 1;
        }// get n-1=2^s * t
        for (int i = 0; i < 10 && prime[i] < n; ++i) {
            int m = prime[i];
            int b = 1, p = t;
            while (p != 0) { //get b=a^t
                if (p % 2 != 0)
                    b = (int)(((long) b * m) % n);
                m = (int)(((long)m * m) % n);
                p >>= 1;
            }
            if (b == 1) continue;
            for (int j = 1; j <= s; ++j) { // double check
                int k = (int)(((long)b * b) % n);
                if(k == 1 && b != n-1 && b!=1) return false;
                b = k;
            }
            if (b != 1) return false;
        }
        return true;
    }
}
