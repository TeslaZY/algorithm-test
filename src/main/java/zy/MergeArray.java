package zy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author Tesla.Z
 * @version 10.0
 * Created by Tesla.Z on 2020/9/3
 */
public class MergeArray {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        int m = Integer.valueOf(str);
        int[] num1 = new int[m];
        for (int i = 0; i < m; i++) {
            num1[i] = Integer.valueOf(buf.readLine());
        }
        str = buf.readLine();
        int n = Integer.valueOf(str);
        int[] num2 = new int[n];
        for (int i = 0; i < n; i++) {
            num2[i] = Integer.valueOf(buf.readLine());
        }
        int array[] = new int[m + n];
        int index = 0;
        int i = 0, j = 0;
        for (i = 0, j = 0; i < m && j < n; ) {
            if (num1[i] <= num2[j]) {
                array[index] = num1[i];
                i++;
            } else if (num1[i] > num2[j]) {
                array[index] = num2[j];
                j++;
            }
            index++;
        }
        if (i == m) {
            for (int k = j; k < n && index < n + m; k++) {
                array[index++] = num2[k];
            }
        } else {
            for (int k = i; k < m && index < n + m; k++) {
                array[index++] = num1[k];
            }
        }
        String result = Arrays.toString(array);
        String MD5 = md5(result);
        out.write(MD5);
        out.flush();
    }

    public static String md5(String source) {
        String des = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] result = md.digest(source.getBytes());
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
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
