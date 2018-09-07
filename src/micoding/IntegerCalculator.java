package micoding;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.*;

public class IntegerCalculator extends SuperCodeClass{
    @Override
    public String solution(String line) {
        String[] arrays = line.split(" ");
        Stack<String> stack_num = new Stack<String>();
        Stack<String> stack_op = new Stack<String>();
        Pattern pattern = Pattern.compile("[0-9]*");
        int i = 0, temp, result;
        for (i = 0; i < arrays.length; i++) {
            Matcher isNum = pattern.matcher(arrays[i]);
            if (isNum.matches()) {
                stack_num.push(arrays[i]);
            } else if (arrays[i].equals("+")) {
                stack_op.push(arrays[i]);
            }else if(arrays[i].equals("-")) {
                stack_op.push(arrays[i]);
                stack_num.push("-"+arrays[++i]);
            }else if (arrays[i].equals( "*")) {
                temp = Integer.valueOf(stack_num.pop()) * Integer.valueOf(arrays[++i]);
                stack_num.push(Integer.toString(temp));
            } else if (arrays[i].equals("/")) {
                if (arrays[i+1].equals("0")) {
                    return "err";
                }
                temp = Integer.valueOf(stack_num.pop()) / Integer.valueOf(arrays[++i]);
                stack_num.push(Integer.toString(temp));
            }
        }
        String operator;
        while (!stack_op.empty()) {
                operator = stack_op.pop();
                temp = Integer.valueOf(stack_num.pop()) + Integer.valueOf(stack_num.pop());
                stack_num.push(Integer.toString(temp));
        }
        return stack_num.pop();
    }

    public static void main(String[] args){
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            line=in.nextLine();
            System.out.println(new IntegerCalculator().solution(line));
        }
    }
}
