package micoding;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseArray extends SuperCodeClass {

    @Override
    public String solution(String line) {
        String[] arrays = line.split(",");
        ArrayList<String> left_str = new ArrayList<String>();
        ArrayList<String> right_str = new ArrayList<String>();
        // 在此处理单行数据
        int i,j;
        for(i=0;i<arrays.length-1;i++){
            if(Integer.valueOf(arrays[i+1])<Integer.valueOf(arrays[i])){
                break;
            }
        }
        for(j=0;j<=i;j++){
            left_str.add(arrays[j]);
        }
        Collections.reverse(left_str);
        for(j=i+1;j<arrays.length;j++){
            right_str.add(arrays[j]);
        }
        Collections.reverse(right_str);
        // 返回处理后的结果
        int mid = arrays.length/2;
        String[] arrays_temp = new String[arrays.length];
        for(j=0;j<right_str.size();j++){
            arrays_temp[j]=right_str.get(right_str.size()-j-1);
        }
        for(j=0;j<left_str.size();j++){
            arrays_temp[j+left_str.size()]=left_str.get(left_str.size()-j-1);
        }
        return arrays_temp[mid];
    }

    public static void main(String[] args){
        String line = input();
        System.out.println(new ReverseArray().solution(line));
    }
}
