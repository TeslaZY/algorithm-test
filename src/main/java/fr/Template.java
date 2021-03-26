package fr;

import java.io.*;

/**
 * @Author: Tesla.Z
 * @Date: 2021/3/26 16:05
 * @Description
 */
public class Template {
    public static void main(String[] args) throws IOException{
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        while ((int) in.nval != -1) {
            int n = (int) in.nval;
            if(in.nextToken() == StreamTokenizer.TT_EOF){
                break;
            }
        }
//        for (int i = 1; i <= COUNT; i++) {
//            if (bitSet[i]==1) {
//                out.write(String.valueOf(i));
//                out.write("\n");
//            }
//        }
        out.flush();
    }
}
