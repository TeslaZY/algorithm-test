package zy;

import java.io.*;

/**
 * @Author: Tesla.Z
 * @Date: 2021/5/6 11:25
 * @Description
 */
public class ArrayRotation {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int index = (int) in.nval;
        in.nextToken();
        char[] array = in.sval.toCharArray();
        rotate(array,0,index-1);
        rotate(array,index,array.length-1);
        for(int i =array.length-1;i>=0;i--){
            out.write(array[i]);

        }
        out.write("\n");
        out.flush();
    }

    public static void rotate(char[] array, int start, int end){
        char temp;
        while(start < end){
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;end--;
        }
    }
}
