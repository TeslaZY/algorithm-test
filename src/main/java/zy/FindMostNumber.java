package zy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tesla.Z
 * @version 10.0
 * Created by Tesla.Z on 2020/9/2
 */
public class FindMostNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        int n = Integer.valueOf(str);
        int mostInt = 0, time = 0, inputNumber = 0;
        for (int i = 0; i < n; i++) {
            inputNumber = Integer.valueOf(buf.readLine());
            if (time == 0) {
                mostInt = inputNumber;
                time = 1;
            } else if (inputNumber == mostInt) {
                time++;
            } else {
                time--;
            }
        }
        System.out.println(mostInt);
    }
}
