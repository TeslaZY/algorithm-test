package micoding;

import java.util.HashMap;
import java.util.Scanner;

public class FirstMissingPositiveNumber extends SuperCodeClass{
    @Override
    public String solution(String line){
        String[] str_arrays = line.split(",");
        int i=0;
        int[] arrays = new int[str_arrays.length];
        for(i=0;i<str_arrays.length;i++){
            arrays[i] = Integer.valueOf(str_arrays[i]);
        }
        HashMap<Integer,Boolean>map = new HashMap<Integer, Boolean>();
        int max=0;
        for(i=0;i<arrays.length;i++){
            if(arrays[i]>0){
                map.put(arrays[i],true);
                max= arrays[i]>max ? arrays[i] : max;
            }
        }
        String result=null;
        for(i=1;i<=max+1;i++){
            if(map.get(i)==null){
                result=Integer.toString(i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new FirstMissingPositiveNumber().solution(line));
        }
    }
}
