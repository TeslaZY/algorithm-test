package micoding;

import java.util.Scanner;

/**
 * @author TeslaZY
 */
public class SuperCodeClass {

    public static String input() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        return line;
    }

    public String solution(String line) {
        return line;
    }

    /*
    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(new RemoveKNumber().solution(line));
        }
    }
    */
}
