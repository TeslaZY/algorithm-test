package sort;

import java.util.Scanner;

public class Insertion extends SuperSort{
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] array = null;
        array = in.nextLine().split(" +");
        sort(array);
        assert isSorted(array);
        show(array);
    }

    public static void exeSort(String[] array){
        sort(array);
        assert isSorted(array);
        show(array);
    }
}
