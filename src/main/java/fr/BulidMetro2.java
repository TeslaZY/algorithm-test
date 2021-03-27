package fr;

import java.io.*;
import java.util.*;

/**
 * By Tesla 2021-3-26
 */

public class BulidMetro2 {


    int n ;
    int m ;
    long[][] cost;
    boolean[][] stations;
    long[][] weight;
    long[] lx;
    long[] ly;
    boolean[] sx;
    boolean[] sy;
    int[] match;

    public BulidMetro2(int n, int m) {
        this.n = n;
        this.m = m;
        this.cost  = new long[n+1][m+1];
        this.stations  = new boolean[n+1][m+1];
        this.weight = new long[n+1][n+1];
        this.lx = new long[n+1];
        this.ly = new long[n+1];
        this.sx = new boolean[n+1];
        this.sy = new boolean[n+1];
        this.match = new int[n+1];
    }

    public static void main(String[] args) throws IOException{

        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;


        BulidMetro2 bm = new BulidMetro2(n,m);

        for (int i =1;i<=n;i++){
            bm.cost[i] = new long[m+1];
            for(int j =1;j<=m;j++){
//                bm.cost[i][j] = sc.nextInt();
                in.nextToken();
                bm.cost[i][j] = (int) in.nval;
            }
        }

        for(int i=1;i<=n;i++){
//            int count = sc.nextInt();
            in.nextToken();
            int count = (int) in.nval;
            bm.stations[i] = new boolean[m+1];{
                for(int j = 1;j<=count;j++){
//                    int stationIndex = sc.nextInt();
                    in.nextToken();
                    int stationIndex = (int) in.nval;
                    bm.stations[i][stationIndex] = true;
                }
            }
        }


        for(int i =1;i<=n;i++){
            for(int j =1;j<=n;j++){
                boolean[] station = bm.stations[i];
                long[] costByDeep = bm.cost[j];
                long costSumByDeep  = 0l;
                for(int k =1;k<=m;k++){
                    if(station[k]) {
                        costSumByDeep += costByDeep[k];
                    }
                }
                bm.weight[i][j] = -costSumByDeep;
//                System.out.print(costSumByDeep);
//                System.out.print("  ");
            }
//            System.out.println();
        }
//        System.out.println(bm.kuhnMunkras(false));
        out.write(String.valueOf(bm.kuhnMunkras(false)));
        out.write("\n");
        out.flush();
    }

    boolean search_path(int u) {
        int v;
        sx[u]=true;
        for(v=1; v<=n; v++){
            if(!sy[v] &&lx[u]+ly[v] == weight[u][v]){
                sy[v]=true;
                if(match[v]==-1 || search_path(match[v])){
                    match[v]=u;
                    return true;
                }
            }
        }
        return false;
    }

    long kuhnMunkras(boolean max_weight){
        int i,j,u;
        long inc,sum;
//        if(!max_weight){
//            for(i=1;i<=n;i++)
//                for(j=1;j<=n;j++)
//                    weight[i][j]=-weight[i][j];
//        }
        for(i=1;i<=n;i++){
            lx[i]=-0x7fffffff;
            for(j=1;j<=n;j++)
                if(lx[i]<weight[i][j])
                    lx[i]=weight[i][j];
        }
        for(j=1;j<=n;j++)ly[j]=0;
        Arrays.fill(match,-1);


        for(u=1;u<=n;u++){
            while(true){
                Arrays.fill(sx,false);
                Arrays.fill(sy,false);
                if(search_path(u))
                    break;

                inc=0x7fffffff;
                for(i=1;i<=n;i++)
                {
                    if(sx[i])
                        for(j=1;j<=n;j++)
                        {
                            if(!sy[j]&&((lx[i] + ly [j] - weight[i][j] )<inc)) inc = lx[i] + ly [j] - weight[i][j] ;
                        }
                }

                for(i=1;i<=n;i++){
                    if(sx[i])
                        lx[i]-=inc;
                }
                for(i=1;i<=n;i++){
                    if(sy[i])
                        ly[i]+=inc;
                }
            }

        }
        sum=0l;
        for(i=1;i<=n;i++)
            if(match[i]>=0)
                sum+=weight[match[i]][i];

        if(!max_weight)
            sum=-sum;
        return sum;

    }


}
