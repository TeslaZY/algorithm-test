package micoding;

import java.util.HashMap;
import java.util.Scanner;

public class TripleSumZero extends SuperCodeClass {
    @Override
    public String solution(String line) {
    String[] str_arrays = line.split(",");
    int[] arrays = new int[str_arrays.length];
    int i = 0,j=0,temp=0,left=0,right=0,count=0,sum;

    for(i=0;i<str_arrays.length;i++){
        arrays[i]=Integer.valueOf(str_arrays[i]);
    }
    //对数组进行插入排序
    for(i=1;i<arrays.length;i++){
        for(j=i;j>0&&arrays[j]<arrays[j-1];j--){
            temp=arrays[j];
            arrays[j]=arrays[j-1];
            arrays[j-1]=temp;
        }
    }
    HashMap<String,String> map = new HashMap<String,String>();
    StringBuilder str = new StringBuilder();
    for(i=0;i<arrays.length-2;i++){
        temp=arrays[i];
        left = i+1;
        right = arrays.length-1;
        while(left<right){
            sum=temp+arrays[left]+arrays[right];
            if(sum==0) {
                str.append(Integer.toString(temp)).append(" ").
                        append(Integer.toString(arrays[left])).append(" ").
                        append(arrays[right]);
                if (!map.containsKey(str.toString())) {
                    count++;
                    //System.out.printf("%d %d %d\n", temp, arrays[left], arrays[right]);
                    map.put(str.toString(),"has");
                }
                str.delete(0,str.length());
                left++;
                right--;
            }
            else if(sum<0){
                left++;
            }else{
                right--;
            }
        }
    }
        return Integer.toString(count);
    }


    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(new TripleSumZero().solution(line));
        }
    }
}
