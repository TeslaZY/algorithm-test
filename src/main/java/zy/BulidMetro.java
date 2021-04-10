package zy;

import java.util.*;

/**
 * By Tesla 2021-3-26
 */

public class BulidMetro {


    int n ;//n条地铁
    int m ;//m个站点
    long[][] cost;;//表示地铁m在第n的的花费
    boolean[][] stations;//表示地铁n是否经过地铁站m
    long[][] weight;//表示地铁n在第n层运行的花费
    long[] lx;
    long[] ly;
    boolean[] sx;
    boolean[] sy;
    int[] match;

    public BulidMetro(int n, int m) {
        this.n = n;
        this.m = m;
        this.cost  = new long[n+1][m+1];//表示地铁m在第n的的花费
        this.stations  = new boolean[n+1][m+1];//表示地铁n是否经过地铁站m
        this.weight = new long[n+1][n+1];//表示地铁n在第n层运行的花费
        this.lx = new long[n+1];
        this.ly = new long[n+1];
        this.sx = new boolean[n+1];
        this.sy = new boolean[n+1];
        this.match = new int[n+1];
    }

    public static void main(String[] args) {

        System.setProperty("file.encoding","utf-8");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n条地铁
        int m = sc.nextInt();//m个站点
        BulidMetro bm = new BulidMetro(n,m);

        //获取输入j地铁站在第i层修建一条地铁出入口的花费
        for (int i =1;i<=n;i++){
            bm.cost[i] = new long[m+1];
            for(int j =1;j<=m;j++){
                bm.cost[i][j] = sc.nextInt();
            }
        }

        //获取第i条地铁过不过第j个地铁站的信息
        for(int i=1;i<=n;i++){
            int count = sc.nextInt();
            bm.stations[i] = new boolean[m+1];{
                for(int j = 1;j<=count;j++){
                    int stationIndex = sc.nextInt();
                    bm.stations[i][stationIndex] = true;
                }
            }
        }

        //计算第i条地铁在第j层运行时候的花费
        //map[i][j] 表示第i条地铁在第j层运行的总花费
        //问题转化成了带权值的
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

        System.out.println(bm.kuhnMunkras(false));
    }

    boolean search_path(int u) {   //给x[u]找匹配,这个过程和匈牙利匹配是一样的
        int v;
        sx[u]=true;
        for(v=1; v<=n; v++){
            if(!sy[v] &&lx[u]+ly[v] == weight[u][v]){	//对于还没搜索过的且在相等子图中的点
                sy[v]=true;  //标记一下表示搜索过
                if(match[v]==-1 || search_path(match[v])){	//名花无主或者还能腾出个位置（使用递归）
                    match[v]=u;
                    return true;
                }
            }
        }
        return false;
    }

    long kuhnMunkras(boolean max_weight){  //表示求最大匹配(1)还是最小匹配(0)
        int i,j,u;
        long inc,sum;
//        if(!max_weight){ //如果求最小匹配，则要将边权取反
//            for(i=1;i<=n;i++)
//                for(j=1;j<=n;j++)
//                    weight[i][j]=-weight[i][j];
//        }
        //初始化顶标，lx[i]设置为max(weight[i][j] | j=0,..,n-1 ), ly[i]=0;
        for(i=1;i<=n;i++){
            lx[i]=-0x7fffffff;
            for(j=1;j<=n;j++)
                if(lx[i]<weight[i][j])
                    lx[i]=weight[i][j];
        }
        for(j=1;j<=n;j++)ly[j]=0;
        Arrays.fill(match,-1);

        //不断修改顶标，直到找到完备匹配或完美匹配
        for(u=1;u<=n;u++){   //为x里的每一个点找匹配
            while(true){
                Arrays.fill(sx,false);
                Arrays.fill(sy,false);
                if(search_path(u))       //x[u]在相等子图找到了匹配,继续为下一个点找匹配
                    break;
                //如果在相等子图里没有找到匹配，就修改顶标，直到找到匹配为止
                //首先找到修改顶标时的增量inc, min(lx[i] + ly [i] - weight[i][j],inc);,lx[i]为搜索过的点，ly[i]是未搜索过的点,因为现在是要给u找匹配，所以只需要修改找的过程中搜索过的点，增加有可能对u有帮助的边
                inc=0x7fffffff;
                for(i=1;i<=n;i++)
                {
                    if(sx[i])		//x是搜索过的点
                        for(j=1;j<=n;j++)
                        {
                            if(!sy[j]&&((lx[i] + ly [j] - weight[i][j] )<inc)) inc = lx[i] + ly [j] - weight[i][j] ;	//y是未搜索过的点
                        }
                }
                //找到增量后修改顶标，因为sx[i]与sy[j]都为真，则必然符合lx[i] + ly [j] =weight[i][j]，然后将lx[i]减inc，ly[j]加inc不会改变等式，但是原来lx[i] + ly [j] ！=weight[i][j]即sx[i]与sy[j]最多一个为真，lx[i] + ly [j] 就会发生改变，从而符合等式，边也就加入到相等子图中
                for(i=1;i<=n;i++){
                    if(sx[i])
                        lx[i]-=inc;		//所有已搜索过的x减少相同的量，便于给其他的x找其他的路径
                }
                for(i=1;i<=n;i++){
                    if(sy[i])
                        ly[i]+=inc;		//对应的ly[]加上inc使得Lx[]+Ly[]与weight[]始终保持一致
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
