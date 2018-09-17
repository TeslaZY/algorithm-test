package micoding;

import java.util.HashMap;
import java.util.Scanner;

public class NumberToCN extends SuperCodeClass {
    @Override
    public String solution(String line) {
        final HashMap<String, String> CN_VALUES = new HashMap<String, String>();
        CN_VALUES.put("0", "零");
        CN_VALUES.put("1", "壹");
        CN_VALUES.put("2", "贰");
        CN_VALUES.put("3", "叁");
        CN_VALUES.put("4", "肆");
        CN_VALUES.put("5", "伍");
        CN_VALUES.put("6", "陆");
        CN_VALUES.put("7", "柒");
        CN_VALUES.put("8", "捌");
        CN_VALUES.put("9", "玖");
        final String[] CN_UNIT = {"仟", "佰", "拾", ""};
        final String[] CN_KILOBIT = {"亿", "万"};
        final int YI_SPLIT = 4;
        final int WAN_SPLIT = 8;
        final int TOP = 12;
        char[] chars = line.toCharArray();

        String[] values = new String[12];
        int i = 0;
        for(i=0;i<TOP;i++){
            values[i]="0";
        }
        for (i = 0; i < chars.length; i++) {
            values[values.length - 1 - i] = Character.toString(chars[chars.length - 1 - i]);
        }
        i = 0;
        StringBuilder result = new StringBuilder();
        boolean zero_flag = true;
        boolean pre_is_zero = false;
        while (i < TOP) {
            if (!values[i].equals("0")) {
                if(pre_is_zero==true){
                    result.append(CN_VALUES.get("0"));
                }
                result.append(CN_VALUES.get(values[i]));
                result.append(CN_UNIT[i%4]);
                zero_flag = false;
                pre_is_zero = false;
            } else {
                if (zero_flag == true) {
                } else {
                    if (pre_is_zero == true) {
                    } else {
                        pre_is_zero = true;
                    }
                }
            }
            if(i==3&&zero_flag!=true){
                result.append("亿");
            }
            if(i==7&&zero_flag!=true){
                result.append("万");
                pre_is_zero=false;
            }
            i++;
        }
        if(zero_flag==true){
            result.append("零");
        }
        result.append("元整");
        return result.toString();
    }


    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(new NumberToCN().solution(line));
        }
    }

}
