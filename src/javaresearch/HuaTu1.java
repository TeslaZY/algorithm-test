package javaresearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HuaTu1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int josephus(int n, int m) {
        List<Integer> alist = new ArrayList();
        int result = -1;

        for (int i = 0; i < n; i++) {
            alist.add(i + 1);
        }

        int i = -1;
        int count = 0;
        while (alist.size() != 0) {
            ++i;
            if (i == alist.size()) {
                i = 0;
            }
            ++count;
            if (count == m) {//输出
                result = alist.remove(i);
                count = 0;
                i--;//修正
            }
        }
        return  result;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = josephus(_n, _m);
        System.out.println(String.valueOf(res));

    }
}
