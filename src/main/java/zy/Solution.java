package zy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Tesla.Z
 * @Date: 2021/4/12 11:00
 * @Description
 */
class Solution {

    private static String ZERO = "0";


    public String largestNumber(int[] nums) {
        String[] list = new String[nums.length];
        for(int i =0;i<nums.length;i++){
            list[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if(list[0].charAt(0) == '0'){
            return ZERO;
        }else {
            StringBuilder sb = new StringBuilder();
            for(int i =0;i<nums.length;i++){
                sb.append(list[i]);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numArray[][] = {
                {0,0,0,0},
                {1,33,0,4},
                {2,4,56,78,233,456,8},
                {1,2,3,4,5,6,7,8,9}
        };
        for(int[] nums : numArray ) {
            System.out.println(solution.largestNumber(nums));
        }
    }
}
