package search;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String[] array= in.nextLine().split(" ");
        int result=0;
        for(int i=0;i<array.length;i++){
            int a=Integer.valueOf(array[i]);
            result=result^a;
        }
        System.out.println(result);
    }
}
