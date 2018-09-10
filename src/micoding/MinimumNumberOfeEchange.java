package micoding;

import java.util.Scanner;

/**
 * @author TeslaZY
 * 还是模拟原始做法：
 *
 * 4 8 2 7 5 6 1 3
 * 1 4 8 2 7 5 6 3------>6次
 *
 * 1 2 4 8 7 5 6 3------>2次
 *
 * 1 2 3 4 8 7 5 6------>5次
 *
 * 1 2 3 4 5 8 7 6------>2次
 *
 * 1 2 3 4 5 6 8 7------>2次
 *
 * 1 2 3 4 5 6 7 8------>1次
 */
public class MinimumNumberOfeEchange extends SuperCodeClass{
    @Override
    public String solution(String line) {
        String[] str_arrays = line.split(",");
        int arrays[] = new int[str_arrays.length];
        int i = 0, j = 0, count = 0;
        for (i = 0; i < str_arrays.length; i++) {
            arrays[i] = Integer.valueOf(str_arrays[i]);
        }
        boolean finish = true;
        while (true) {
            int index = -1;
            int min_value = Integer.MAX_VALUE;
            for (i = 0; i < arrays.length; i++) {
                if (arrays[i] != -1 && arrays[i] < min_value) {
                    min_value = arrays[i];
                    index = i;
                }
            }
            for (j = 0; j < index; j++) {
                if (arrays[j] != -1 && arrays[j] > min_value) {
                    count++;
                }
            }
            arrays[index] = -1;
            for (j = 0; j < arrays.length; j++) {
                if (arrays[j] != -1) {
                    finish = false;
                    break;
                }
            }

            if (finish) {
                break;
            }
            finish = true;
        }
        return Integer.toString(count);
    }

    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new MinimumNumberOfeEchange().solution(line));
        }
    }

}
