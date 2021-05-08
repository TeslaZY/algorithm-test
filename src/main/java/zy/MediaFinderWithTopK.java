package zy;

import java.io.InputStream;
import java.io.ObjectInputStream;

public class MediaFinderWithTopK {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
//        InputStream input = new FileInputStream(new File("/Users/zhangyuyu/Downloads/OJdata/22/1.in"));
        final int n = 10000000;
        int[] a = new int[n];
        final int k = n >> 1;
        ObjectInputStream in = new ObjectInputStream(input);
        for (int i = 0; i < n; i++) {
            a[i] = in.readInt();
        }

        f(a, 0, n - 1, k);
        f(a, 0, k - 1, k - 1);
        System.out.println((a[k] + a[k - 1]) >> 1);
    }

    static void f(int[] a, int l, int r, int k) {
        if (l > r) {
            return;
        }
        if (l == r && l == k) {
            return;
        }
        int t = a[r], L = l, R = r;
        while (l < r) {
            for (; l < r && a[l] <= t; l++) ;
            a[r] = a[l];
            for (; l < r && a[r] >= t; r--) ;
            a[l] = a[r];
        }
        a[l] = t;
        if (l == k) {
            return;
        } else if (l > k) {
            f(a, L, l - 1, k);
        } else {
            f(a, l + 1, R, k);
        }
    }
}