package javaresearch;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i,n,q;
        n = input.nextInt();
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(i=1;i<=n;i++){
            map.put(i,input.nextInt());
        }
        q = input.nextInt();
        int j=0,count=0;
        int l,r,k;
        for(i=0;i<q;i++){
            count=0;
            l=input.nextInt();
            r=input.nextInt();
            k=input.nextInt();
            for(j=l;j<=r;j++){
                if(map.get(j)==k){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
