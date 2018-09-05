package micoding;

import java.util.*;

public class BigNumberSub extends SuperCodeClass{
    @Override
    public String solution(String line){
        int i,aint,bint;
        String[] arrays = line.split(" - ");
        char[] a = new StringBuffer(arrays[0]).reverse().toString().toCharArray();
        char[] b = new StringBuffer(arrays[1]).reverse().toString().toCharArray();
        int alen = a.length;
        int blen = b.length;

        int len = alen>blen ? alen : blen;
        int[] result = new int[len];

        char sign = '+';
        if(alen<blen){
            sign='-';
        }else if(alen==blen){
            i = alen - 1;
            while(i>0&&a[i]==b[i]){
                i--;
            }
            if(a[i]<b[i]) {
                sign = '-';
            }
        }

        for( i =0; i<len; i++){
            aint = i<alen ? (a[i] - '0') : 0;
            bint = i<blen ? (b[i] - '0') : 0;
            if(sign=='+'){
                result[i]= aint-bint;
            }
            else{
                result[i] = bint-aint;
            }
        }

        for(i=0;i<result.length-1;i++){
            if(result[i]<0){
                result[i+1]-=1;
                result[i]+=10;
            }
        }
        StringBuffer str =new StringBuffer();

        if(sign=='-'){
            str.append('-');
        }

        boolean flag =true;
        for(i =len - 1;i>=0;i--){
            if(result[i] == 0 && flag){
                continue;
            }else{
                flag = false;
            }
            str.append(result[i]);
        }

        if(str.toString().equals("")){
            str.append('0');
        }

        return str.toString();
    }

    public static void main(String[] args) {
        String line = input();
        System.out.println(new BigNumberSub().solution(line));
    }
}
