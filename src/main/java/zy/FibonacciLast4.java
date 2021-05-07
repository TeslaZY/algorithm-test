package zy;

/**
 * @Author: Tesla.Z
 * @Date: 2021/5/7 15:07
 * @Description
 */
public class FibonacciLast4 {

    private int[][] ret = new int[2][2];
    private int[][] tmp = new int[2][2];
    private int[][] p = new int[2][2];
    private static final int mod = 10000;

    public FibonacciLast4() {
        init();
    }

    private void init() {
        ret[0][0] = 1;
        ret[0][1] = 1;
        ret[1][0] = 1;
        ret[1][1] = 0;
        p[0][0] = 1;
        p[0][1] = 1;
        p[1][0] = 1;
        p[1][1] = 0;
    }

    private long getFibLast4(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            fastMod(n);
            return ret[0][0];
        }
    }

    //矩阵的平方
    void cal1() {
        int i, j, k;
        for (i = 0; i < 2; i++)
            for (j = 0; j < 2; j++) {
                tmp[i][j] = p[i][j];
                p[i][j] = 0;
            }
        for (i = 0; i < 2; i++)
            for (j = 0; j < 2; j++)
                for (k = 0; k < 2; k++)
                    p[i][j] = (p[i][j] + tmp[i][k] * tmp[k][j]) % mod;
    }

    //矩阵的乘法
    void cal2() {
        int i, j, k;
        for (i = 0; i < 2; i++)
            for (j = 0; j < 2; j++) {
                tmp[i][j] = ret[i][j];
                ret[i][j] = 0;
            }
        for (i = 0; i < 2; i++)
            for (j = 0; j < 2; j++)
                for (k = 0; k < 2; k++)
                    ret[i][j] = (ret[i][j] + tmp[i][k] * p[k][j]) % mod;
    }

    //快速幂运算，减少矩阵幂乘法的次数
    void fastMod(int n) {
        n -= 2;
        while (n != 0) {
            if ((n & 1) == 0) {
                cal1();
                n >>= 1;
            } else {
                cal2();
                n--;
            }
        }
    }

}
