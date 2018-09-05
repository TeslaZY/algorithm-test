package micoding;

import java.util.HashMap;
import java.util.Map;

public class LongestContinuousSeries extends SuperCodeClass{
    @Override
    public String solution(String line) {
        String[] str_arrays = line.split(",");
        int[] arrays = new int[str_arrays.length];
        for(int i=0;i<str_arrays.length;i++){
            arrays[i]=Integer.valueOf(str_arrays[i]);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (map.get(arrays[i])==null) {
                int left = map.get(arrays[i]-1)==null?0:map.get(arrays[i]-1);
                int right = map.get(arrays[i]+1)==null?0:map.get(arrays[i]+1);
                int length = left + right + 1;
                map.put(arrays[i], length);
                if (left != 0) {
                    map.put(arrays[i]-left, length);
                }
                if (right != 0) {
                    map.put(arrays[i]+left, length);
                }
                max = max > length ? max : length;
            }
        }

        return Integer.toString(max);
    }

    public static void main(String[] args){
        String line = input();
        System.out.println(new LongestContinuousSeries().solution(line));
    }
}
