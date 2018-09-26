package javaresearch;
import java.util.Scanner;

public class Pinduoduo3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        int m =scan.nextInt();
        int i=0,j=0,k=0;
        int[] price = new int[n];
        int[][] discount = new int[m][2];
        int[][] dp = new int[n][n+1];
        for(i=0;i<n;i++){
            price[i]=scan.nextInt();
        }
        for(i=0;i<m;i++){
            discount[i][0]=scan.nextInt();
            discount[i][1]=scan.nextInt();
        }
        /*
        *dp[i][j] 买i件商品  最少需要j元
        *计算的时候应该是dp[i-1][j-min(price)]
        *min(price)是在满减优惠下，所计算出的最便宜单价
        */
        int mini_price = min_price(price,discount);
        for(i=0;i<dp.length;i++){
            dp[i][0]=mini_price;
            if(i==0){
                for(j=1;j<dp[i].length;j++){
                    for(k=0;k<price.length;k++){
                    }
                }
            }
        }
        System.out.println(discount);
    }
    public static int min_price(int[] price,int[][] discount){
        int i=0,j=0;
        int min_price=Integer.MAX_VALUE;
        for(i=0;i<price.length;i++){
            for(j=0;j<discount.length;j++){
                if(price[i]>discount[j][0]){
                    min_price = min_price>price[i]-discount[j][1]?price[i]-discount[j][1]:min_price;
                }
            }
        }
        return min_price;
    }
}
