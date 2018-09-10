package sort;

import java.util.Scanner;

/**
 * @author TeslaZY
 */
public class Selection extends SuperSort {

    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);
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

    public static void execSort(String[] array){
        sort(array);
        assert isSorted(array);
        show(array);
    }

}
