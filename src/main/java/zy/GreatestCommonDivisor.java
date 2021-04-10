package zy;

import java.io.*;

public class GreatestCommonDivisor {
    private static int divisor(int a, int b) {
        int temp;
        if(a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while(b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.valueOf(in.readLine());
        int b = Integer.valueOf(in.readLine());
        out.write(divisor(a,b));
        out.flush();
    }
}
