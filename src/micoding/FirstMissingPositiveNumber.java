package micoding;

import java.util.Scanner;

public class FirstMissingPositiveNumber extends SuperCodeClass{
    @Override
    public String solution(String line){
        return line;
    }

    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new CrossQueue().solution(line));
        }
    }
}
