package micoding;

import java.util.Scanner;

public class DpCombinations {
    public String solution(String line) {
        String[] args = line.split(" ");
        String[] str_arrays = args[0].split(",");
        int aim = Integer.valueOf(args[1]);
        int i=0;
        int[] arr = new int[str_arrays.length];
        for(i=0;i<str_arrays.length;i++){
            arr[i]=Integer.valueOf(str_arrays[i]);
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (i = 0; i < dp.length; i++) {
            // 凑成0元的方法必然是什么货币都不用，只有1种
            dp[i][0] = 1;
            if (i == 0) {
                // 如果只是用arr[0]这一种货币，则能凑到j钱置1
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = j % arr[i] == 0 ? 1 : 0;
                }
            } else {
                for (int j = 1; j < dp[i].length; j++) {
                    int temp = 0;
                    // 枚举使用k张arr[i]货币后dp[i-1]中组成剩下钱数的方法数
                    for (int k = 0; k * arr[i] <= j; k++) {
                        //方法数累加
                        temp += dp[i - 1][j - k * arr[i]];
                    }
                    dp[i][j] = temp;
                }
            }
        }
        // 返回dp矩阵最右下角的值即为最后结果
        return Integer.toString(dp[arr.length - 1][aim]);
    }

 /*   public static int process(int[] arr,int aim) {
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            // 凑成0元的方法必然是什么货币都不用，只有1种
            dp[i][0] = 1;
            if (i == 0) {
                // 如果只是用arr[0]这一种货币，则能凑到j钱置1
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = j % arr[i] == 0 ? 1 : 0;
                }
            } else {
                for (int j = 1; j < dp[i].length; j++) {
                    int temp = 0;
                    // 枚举使用k张arr[i]货币后dp[i-1]中组成剩下钱数的方法数
                    for (int k = 0; k * arr[i] <= j; k++) {
                        //方法数累加
                        temp += dp[i - 1][j - k * arr[i]];
                    }
                    dp[i][j] = temp;
                }
            }
        }
        // 返回dp矩阵最右下角的值即为最后结果

        return dp[arr.length - 1][aim];
    }
*/

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            line = in.nextLine();
            System.out.println(new DpCombinations().solution(line));
        }
    }

}
