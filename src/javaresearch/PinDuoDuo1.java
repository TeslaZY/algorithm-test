package javaresearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PinDuoDuo1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap<>();
        String line = scanner.nextLine();
        String[] strings = line.split("( |!|_|\\?|,|:|;|\\.)+");
        int i=0,max_count=0;
        Integer count=0;
        for(i=0;i<strings.length;i++){
            strings[i]=strings[i].toLowerCase();
            count = map.get(strings[i]);
            if(count==null){
                map.put(strings[i],1);
            }else{
                map.put(strings[i],count+1);
                max_count=max_count<count+1? count+1:max_count;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(String str : map.keySet()){
            if(map.get(str)==max_count){
                result.add(str);
            }
        }
        sort(result);
        for(i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    public static void sort(ArrayList<String> result){
        int N = result.size();
        int h = 1;
        while(h<N/3) {
            h = h * 3 + 1;
        }
        while(h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h&&less(result.get(j), result.get(j-h));j=j-h){
                    exch(result,j,j-h);
                }
            }
            h=h/3;
        }
    }

    protected static boolean less(String v, String w){
        return v.compareTo(w)<0;
    }

    protected static void exch(ArrayList<String> a, int i, int j){
        String t = a.get(i);
        a.add(i,a.get(j));
        a.add(j,t);
    }
}
