package micoding;

import java.util.Scanner;

public class SearchNumber extends  SuperCodeClass {
    @Override
    public String solution(String line) {
        String[] args = line.split(" ");
        String[] arrays = args[0].split(",");
        String number = args[1];
        int i;
        for(i = 0;i<arrays.length;i++){
            if(arrays[i].equals(number)){
                break;
            }
            if(i==arrays.length-1){
                i=-1;
                break;
            }
        }
        return Integer.toString(i);
    }

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(new SearchNumber().solution(line));
        }
    }

}
