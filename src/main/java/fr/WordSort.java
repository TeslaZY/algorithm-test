package fr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.BitSet;
import java.util.Scanner;

/**
 * @author Tesla.Z
 * @version 10.0
 * Created by Tesla.Z on 2020/9/2
 */
public class WordSort {

    public static void main(String[] args) throws IOException {
        int COUNT = 10000000;
        byte[] bitSet = new byte[COUNT + 1];
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        while ((int) in.nval != -1) {
            int n = (int) in.nval;
            bitSet[n]=1;
            if(in.nextToken() == StreamTokenizer.TT_EOF){
                break;
            }
        }
        for (int i = 1; i <= COUNT; i++) {
            if (bitSet[i]==1) {
                out.write(String.valueOf(i));
                out.write("\n");
            }
        }
        out.flush();
    }
}
