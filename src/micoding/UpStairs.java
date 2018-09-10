package micoding;

import java.util.HashMap;
import java.util.Scanner;

public class UpStairs extends SuperCodeClass {
    @Override
    public String solution(String line) {
        int n = Integer.valueOf(line);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(1,1);
        map.put(2,2);
        for(int i=3;i<=n;i++){
            map.put(i,map.get(i-1)+map.get(i-2));
        }
        return Integer.toString(map.get(n));
    }


    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new UpStairs().solution(line));
        }
    }

}
