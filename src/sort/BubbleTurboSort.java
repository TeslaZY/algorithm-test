package sort;

import java.util.Scanner;

public class BubbleTurboSort extends SuperSort{
    public static void sort(Comparable[] a){
        int N = a.length;
        int count=0;
        Comparable temp;
        for(int i = 0;i != N;++i)
        {
            for (int j = 0; j != N; ++j)
            {
                if (less(a[i] ,a[j]))
                {
                    count++;
                    System.out.print(count+" exchange "+a[i]+"  "+a[j]+"  ");
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    show(a);
                }
            }
            System.out.println("j遍历结束");
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
