package micoding;

import java.util.Scanner;

/**
 * @author TeslaZY
 */
public class RemoveKNumber extends SuperCodeClass{
    @Override
    public String solution(String line){
        String[] temp = line.split(" ");
        char[] arrays = temp[0].toCharArray();
        int k = Integer.valueOf(temp[1]);
        int j=k;
        boolean incr_flag=true;
        while(k>0){
            for(int i =0;i<arrays.length-1;i++) {
                if (arrays[i]!='\0') {
                    int temp_index = 1;
                    while(arrays[i+temp_index]=='\0'){
                        temp_index++;
                    }
                    if(arrays[i]>arrays[i+temp_index]) {
                        arrays[i] = '\0';
                        incr_flag = false;
                        break;
                    }
                }
            }
            k--;
        }
        if(incr_flag){
            int index = arrays.length-1;
            while(j>0){
                arrays[index--]='\0';
                j--;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]!='\0'){
                if(result.length()==0&&arrays[i]=='0'){
                    if(i!=arrays.length-1) {
                        continue;
                    }
                }
                result.append(arrays[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new RemoveKNumber().solution(line));
        }
    }
}
