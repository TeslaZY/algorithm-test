package micoding;

import java.util.Scanner;

public class BigNumberAddorCompare extends SuperCodeClass {
    @Override
    public String solution(String line) {
        int operator = 0;
        if(line.matches("\\d+\\+\\d+")){
            //1代表加号
            operator=1;
        }else if(line.matches("\\d+<\\d+")){
            //2代表<号
            operator=2;
        }else if(line.matches("\\d+>\\d+")){
            //3代表>号
            operator=3;
        }else{
            operator=0;
        }
        String[] args = line.split("\\+|<|>");
        char[] left = new StringBuffer(args[0]).reverse().toString().toCharArray();
        char[] right= new StringBuffer(args[1]).reverse().toString().toCharArray();
        //加法计算
        int i=0;
        int length= (left.length>right.length? left.length : right.length)+1;
        int[] sum = new int[length];
        int result=0;
        StringBuilder result_str = new StringBuilder();
        if(operator==1) {
            while (i < length) {
                if (i < left.length && i < right.length) {
                    result = sum[i]+(left[i] - '0') + (right[i] - '0');
                    if (result > 9) {
                        sum[i + 1] = sum[i + 1] + 1;
                    }
                    sum[i] = result % 10;
                } else if (i < left.length && i >= right.length) {
                    result=sum[i] + left[i] - '0';
                    if (result > 9) {
                        sum[i + 1] = sum[i + 1] + 1;
                    }
                    sum[i] = result % 10;
                } else if (i >= left.length && i < right.length) {
                    result = sum[i] + right[i] - '0';
                    if (result > 9) {
                        sum[i + 1] = sum[i + 1] + 1;
                    }
                    sum[i] = result % 10;
                } else {
                    sum[i] = sum[i] + 0;
                }
                i++;
            }
            for (i = length - 1; i >= 0; i--) {
                if (i == length - 1 && sum[i] != 0) {
                    result_str.append(sum[i]);
                } else if (i < length - 1) {
                    result_str.append(sum[i]);
                }
            }
        }else{
            //默认是left<right
            if(left.length<right.length){
                result=-1;
            }else if(left.length>right.length){
                result=1;
            }else if(left.length==right.length){
                i=left.length-1;
                while(i>0&&left[i]==right[i]){
                    i--;
                }
                if(left[i]<right[i]){
                    result=-1;
                }else if(left[i]==right[i]){
                    result = 0;
                }else{
                    result =1;
                }
            }
            if(operator==2){
                //判断left<right?
                if(result==-1){
                    result_str.append("Y");
                }else {
                    result_str.append("N");
                }
            }else if(operator==3){
                //判断left>right
                if(result==1){
                    result_str.append("Y");
                }else {
                    result_str.append("N");
                }
            }else{
                result_str.append("NULL");
            }
        }
        return result_str.toString();
    }


    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(new BigNumberAddorCompare().solution(line));
        }
    }

}
