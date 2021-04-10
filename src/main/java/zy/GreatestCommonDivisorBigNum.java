package zy;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class GreatestCommonDivisorBigNum {
    private static String divisor(BigInteger a, BigInteger b) {
        BigInteger temp;
        if(a.compareTo(b)==-1) {
            temp = a;
            a = b;
            b = temp;
        }
        while(!b.equals(BigInteger.ZERO)) {
            temp = a.mod(b);
            a = b;
            b = temp;
        }
        return a.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.nextLine());
        BigInteger b = new BigInteger(sc.nextLine());
        String result = divisor(a,b);
        System.out.println(result);
    }
}
