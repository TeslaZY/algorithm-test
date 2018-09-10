package sort;

import java.util.Scanner;

/**
 * @author TeslaZY
 */
public class Shell extends SuperSort {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h<N/3) {
            h = h * 3 + 1;
        }
        while(h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h&&less(a[j],a[j-h]);j=j-h){
                    exch(a,j,j-h);
                }
            }
            h=h/3;
        }
    }

    public static void ececSort(String[] array){
        sort(array);
        assert isSorted(array);
        show(array);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] array = null;
        array = in.nextLine().split(" +");
        sort(array);
        assert isSorted(array);
        show(array);
    }
}
