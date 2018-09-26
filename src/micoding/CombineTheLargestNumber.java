package micoding;

import java.util.Scanner;

public class CombineTheLargestNumber extends SuperCodeClass{
    @Override
    public String solution(String line) {
        String[] args = line.split(" ");
        String[] array_stra = args[0].split(",");
        String[] array_strb = args[1].split(",");
        int[] array_a = new int[array_stra.length];
        int[] array_b = new int[array_strb.length];
        int k = Integer.valueOf(args[2]);
        boolean[] entry_a = new boolean[array_a.length];
        boolean[] entry_b = new boolean[array_b.length];
        int i=0;
        for(i=0;i<array_a.length;i++){
            array_a[i]=Integer.valueOf(array_stra[i]);
        }
        for(i=0;i<array_b.length;i++){
            array_b[i]=Integer.valueOf(array_strb[i]);
        }
        i=0;
        return line;
    }


    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(new CombineTheLargestNumber().solution(line));
        }
    }

}
