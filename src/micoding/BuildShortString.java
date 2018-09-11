package micoding;

import java.util.HashMap;
import java.util.Scanner;

public class BuildShortString extends  SuperCodeClass {
    @Override
    public String solution(String line) {
        String arrays[] = line.split(" ");

        char[] short_array = arrays[0].toCharArray();

        char[] long_array = arrays[1].toCharArray();
        int i=0;
        boolean[] short_flag = new boolean[short_array.length];
        /*HashMap<Character,Integer> long_map = new HashMap<Character,Integer>();

        int i=0,get;
        for(i=0;i<long_array.length;i++){
            long_map.put(long_array[i],long_map.get(long_array[i])==null? 1 : long_map.get(long_array[i])+1);
        }
        boolean[] short_flag = new boolean[short_array.length];

        for(i=0;i<short_array.length;i++){
            if(long_map.get(short_array[i])!=null&&long_map.get(short_array[i])>0){
                short_flag[i]=true;
                long_map.put(short_array[i],long_map.get(short_array[i])-1);
            }
        }
        */
        int[] warehouse = new int[256];
        for(i=0;i<long_array.length;i++){
            warehouse[long_array[i]]+=1;
        }
        for(i=0;i<short_array.length;i++){
            if(warehouse[short_array[i]]>0){
                short_flag[i]=true;
                warehouse[short_array[i]]--;
            }
        }
        String result = "true";
        for(i=0;i<short_array.length;i++){
            if(short_flag[i]==false){
                result = "false";
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(new BuildShortString().solution(line));
        }
    }

}
