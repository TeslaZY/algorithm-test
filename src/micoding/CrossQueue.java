package micoding;

import java.util.Scanner;

public class CrossQueue extends SuperCodeClass{
    @Override
    public String solution(String line){
        String[] arrays = line.split(",");
        String result;
        char[] s1 = arrays[0].toCharArray();
        char[] s2 = arrays[1].toCharArray();
        char[] s3 = arrays[2].toCharArray();
        boolean[] s3_flag = new boolean[s3.length];
        boolean flag1=false,flag2=false;
        if(s1.length+s2.length!=s3.length){
            result = "false";
        }else {
            int i = 0, j = 0, k = 0;
            while (i < s3.length) {
                while (j < s1.length && s3[i] == s1[j]) {
                    s3_flag[i] = true;
                    i++;
                    j++;
                    if(j==s1.length){
                        flag1=true;
                    }
                }
                while (k < s2.length && s3[i] == s2[k]) {
                    s3_flag[i] = true;
                    i++;
                    k++;
                    if(k==s2.length){
                        flag2=true;
                    }

                }
                if (flag1&&flag2) {
                    break;
                }else if(flag1&&s3[i]!=s2[k]){
                    break;
                }
                else if(flag2&&s3[i]!=s1[j]){
                    break;
                }else if(s3[i]!=s1[j]&&s3[i]!=s2[k]){
                    break;
                }

            }
            if (s3_flag[s3.length - 1] == true) {
                result = "true";
            } else {
                result = "false";
            }
        }
        return result;
    }

    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new CrossQueue().solution(line));
        }
    }
}
