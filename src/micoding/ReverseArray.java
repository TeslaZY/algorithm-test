package micoding;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseArray extends SuperCodeClass {

    @Override
    public String solution(String line) {
        String[] arrays = line.split(",");
        ArrayList<String> arrayList = new ArrayList<String>();
        // 在此处理单行数据
        int i,j;
        for(i=0;i<arrays.length-1;i++){
            if(Integer.valueOf(arrays[i+1])<Integer.valueOf(arrays[i])){
                break;
            }
        }
        for(j=i+1;j<arrays.length;j++){
            arrayList.add(arrays[j]);
        }
        for(j=0;j<=i;j++){
            arrayList.add(arrays[j]);
        }
        int mid = arrays.length/2;
        return arrayList.get(mid);
    }

    public static void main(String[] args){
        String line = input();
        System.out.println(new ReverseArray().solution(line));
    }
}
