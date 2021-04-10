package zy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Tesla.Z
 * @version 10.0
 * Created by Tesla.Z on 2020/9/2
 */

public class BiggestNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        int n = Integer.valueOf(str);
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = buf.readLine();
        }
        String result = Arrays.stream(array).parallel().sorted((String s1, String s2) -> (s2 + s1).compareTo(s1 + s2)).collect(Collectors.joining());
        System.out.println(result);
    }
}
