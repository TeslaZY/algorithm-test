package javaresearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HuaTu2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String[] char_count(String[] str_arr) {

        ArrayList<Integer> arrayListcount = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        String pre_str = str_arr[0];
        int count =1;
        for(i=1;i<str_arr.length;){
            if(str_arr[i].equals(pre_str)){
                count++;
                i++;
            }else{
                arrayList.add(pre_str);
                arrayListcount.add(count);
                pre_str=str_arr[i];
                count=1;
                i++;
            }
        }
        arrayList.add(pre_str);
        arrayListcount.add(count);
        String[] res = new String[arrayList.size()*2];
        for(i=0;i<arrayList.size();i++){
            res[2*i] = arrayList.get(i);
            res[2*i+1]= arrayListcount.get(i).toString();
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;

        int _str_arr_size = 0;
        _str_arr_size = Integer.parseInt(in.nextLine().trim());
        String[] _str_arr = new String[_str_arr_size];
        String _str_arr_item;
        for(int _str_arr_i = 0; _str_arr_i < _str_arr_size; _str_arr_i++) {
            try {
                _str_arr_item = in.nextLine();
            } catch (Exception e) {
                _str_arr_item = null;
            }
            _str_arr[_str_arr_i] = _str_arr_item;
        }

        res = char_count(_str_arr);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
