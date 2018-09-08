package micoding;

import java.util.Scanner;

public class ReversePoker {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int i=0;
        int M=0,N=0;
        for(i=0;i<t;i++){
            N = in.nextInt();
            M = in.nextInt();
            boolean[][] matrix = new boolean[N][M];
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    reverse(matrix,j,k,N,M);
                }
            }
            int result = 0;
            for(int j=0;j<N;j++) {
                for (int k = 0; k < M; k++) {
                    if(matrix[j][k]==true){
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static boolean isOutofIndex(int col,int row,int N,int M){
        boolean result=false;
        if(col<0||row<0||col>=N||row>=M){
            result = true;
        }
        return  result;
    }

    public static void reverse_poker(boolean value){
        if(value == true){
            value =false;
        }else{
            value = true;
        }
    }

    public static void reverse(boolean[][] matrix,int col, int row,int N,int M){
        for(int i = -1;i<2;i++){
            for(int j = -1;j<2;j++){
                if(isOutofIndex(col+i,row+j,N,M)){
                    reverse_poker(matrix[col][row]);
                }
            }
        }
    }
}
