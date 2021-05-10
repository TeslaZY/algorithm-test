package zy;


import java.io.*;

public class CNCharCompression {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int n = (int) in.nval;
        boolean ifZero = true;
        for(int i = 0;i<n*n;){
            in.nextToken();
            int num = (int) in.nval;;
            for(int j=0;j<num;j++){
                if(i!=0&&i%n==0){
                    out.write('\n');
                }
                out.write(ifZero ? '0' : '1');
                i++;
            }
            ifZero = !ifZero;
        }
        out.flush();
    }
}
