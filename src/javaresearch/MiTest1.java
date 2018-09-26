package javaresearch;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MiTest1 {
    public static void main(String[] args){
        String line;
        HashMap<Integer,String> map = new HashMap<>(16);
        ArrayList<Integer> list = new ArrayList<>(16);
        Scanner input = new Scanner(System.in);
        String[] arrays = new String[2];
        int value = 0;
        line = input.nextLine();
        while (line!=null&&!line.equals("END")) {
            arrays = line.split("#");
            value = Integer.valueOf(arrays[1],Integer.valueOf(arrays[0]));
            list.add(value);
            map.put(value,line);
            line = input.nextLine();
        }
        int temp = 0;
        HashMap<Integer,Integer> map2 = new HashMap<>(16);
        for(int i=0;i<list.size();i++){
            temp = list.get(i);
            if(map2.containsKey(temp)){
                map2.put(temp,map2.get(temp)+1);
            }else {
                map2.put(temp,1);
            }
        }
        for(Integer in : map2.keySet()){
            if(map2.get(in)==1){
                temp = in;
                break;
            }
        }
        System.out.println(map.get(temp));
    }
}
