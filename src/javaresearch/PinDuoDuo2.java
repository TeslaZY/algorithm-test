package javaresearch;

import java.util.Scanner;

public class PinDuoDuo2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int arrays[] = new int[N];
        int cache_size=1,min_cache_size=0,i,j,step=1000;
        double hit_rate=0.0,max_hit_rate=0.0;
        for(i=0;i<N;i++){
            arrays[i]=scan.nextInt();
        }
        for(i=1;i<=step;i++){
            int[] cache = new int[i];
            for(j=0;j<i;j++){
                cache[j]=-1;
            }
            int count =0;
            for(j=0;j<N;j++){
                if(arrays[j]==cache[j%i]){
                    count++;
                }else{
                    cache[j%i]=arrays[j];
                }
            }
            hit_rate = (double)count/(double)N;
            if(hit_rate>max_hit_rate){
                cache_size = i;
                max_hit_rate = hit_rate;
            }
        }
        System.out.println(cache_size);
    }
}
