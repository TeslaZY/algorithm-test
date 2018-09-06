package micoding;

import java.util.Scanner;

public class MinimumNumberOfeEchange extends SuperCodeClass{
    @Override
    public String solution(String line){
        String[] arrays = line.split(",");
        int i=0,j=0,count =0;
        String temp;
        for(i=1;i<arrays.length;i++){
            for(j=i;j>0&&Integer.valueOf(arrays[j]) < Integer.valueOf(arrays[j - 1]);j--) {
                    temp = arrays[i];
                    arrays[i] = arrays[i - 1];
                    arrays[i - 1] = temp;
                    count++;
            }
        }
        return Integer.toString(count);
    }

    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new MinimumNumberOfeEchange().solution(line));
        }
    }

}
