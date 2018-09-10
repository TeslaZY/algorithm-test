package micoding;

import java.util.Scanner;

public class UpStairs extends SuperCodeClass {
    @Override
    public String solution(String line) {

        int n = Integer.valueOf(line);
        if (n > 0) {
            if (1 == n) {
                return Integer.toString(1);
            } else if (2 == n) {
                return Integer.toString(2);
            } else {
                return Integer.toString(Integer.valueOf(solution(Integer.toString(n-1)))+Integer.valueOf(solution(Integer.toString(n-2))));
            }
        } else{
            return Integer.toString(0);
        }
    }


    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new UpStairs().solution(line));
        }
    }

}
