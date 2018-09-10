package sort;

import java.util.Scanner;

/**
 * @author TeslaZY
 */
public class SortTest {
    public static void main(String[] args){
        String[] input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine().split(" +");
        Shell.ececSort(input);
    }
}
