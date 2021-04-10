package zy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tesla.Z
 * @version 10.0
 * Created by Tesla.Z on 2020/9/3
 */
public class IntersectionArray {
    private static Byte[] bitMap = new Byte[1000000];

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(buf.readLine());
        int[] num1 = new int[m];
        for (int i = 0; i < m; i++) {
            num1[i] = Integer.valueOf(buf.readLine());
        }
        int n = Integer.valueOf(buf.readLine());
        int[] num2 = new int[n];
        for (int i = 0; i < n; i++) {
            num2[i] = Integer.valueOf(buf.readLine());
        }

        int i = 0, j = 0;
        for (i = 0; i < 1000000; i++) {
            bitMap[i] = 1;
        }
        for (i = 0; i < m; i++) {
            bitMap[num1[i]] = 2;
        }
        for (i = 0; i < n; i++) {
            if (bitMap[num2[i]] != null && bitMap[num2[i]] == 2) {
                bitMap[num2[i]] = 3;
            }
        }
        List<Integer> list = new ArrayList();
        for (i = 0; i < 1000000; i++) {
            if (bitMap[i] != null && bitMap[i] == 3) {
                list.add(i);
            }
        }
        Integer[] array = list.toArray(new Integer[0]);
        String result = Arrays.toString(array);
        String MD5 = md5(result);
        out.write(MD5);
        out.flush();
    }

    public static String md5(String source){
        String des = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(source.getBytes());
            StringBuilder buf = new StringBuilder();
            for (int i=0;i<result.length;i++) {
                byte b = result[i];
                buf.append(String.format("%02X", b));
            }
            des = buf.toString().toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("md5 failure");
        }
        return des;
    }

}
