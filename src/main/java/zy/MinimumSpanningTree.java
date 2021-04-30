package zy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Tesla.Z
 * @Date: 2021/4/27 20:01
 * @Description
 */
public class MinimumSpanningTree {
    public static void main(String[] args){
        try {
            StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//            StreamTokenizer in = new StreamTokenizer(new BufferedReader(new FileReader(new File("/Users/zhangyuyu/Downloads/9/mst4.in"))));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            Edge[] edges = null;
            int n =0 ,m = 0;
            while (in.nextToken() != StreamTokenizer.TT_EOF) {
                n = (int) in.nval;
                if(n==1) {out.write('0');out.flush();return;}
                in.nextToken();
                m = (int) in.nval;
                edges = new Edge[m];
                for(int i = 0;i<m;i++){
                    in.nextToken();
                    int start = (int) in.nval;
                    in.nextToken();
                    int end = (int) in.nval;
                    in.nextToken();
                    int weight = (int) in.nval;
                    edges[i] = new Edge(start,end,weight);
                }
                break;
            }

            Arrays.sort(edges, new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.weight - o2.weight ;
                }
            });

            long result_weight = 0l;
            int[] parent = new int[n+1];

//            long time1 = System.currentTimeMillis();
            int count = 0;
            for(int i=0;i<m;i++){
                find(parent, edges[i].begin, edges[i].end);
                if(result[0]!=result[1]){
                    parent[result[0]] = result[1];
                    result_weight += edges[i].weight;
                    count++;
                    if(count==n-1){
                        break;
                    }
                }
            }
//            long time2 = System.currentTimeMillis();
//            System.out.println(time2-time1);

            out.write(String.valueOf(result_weight));
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int[] result = new int[2];

    public static void find(int[] parent, int nodeStart , int nodeEnd){
        while(parent[nodeStart] > 0 || parent[nodeEnd] > 0){
            if(parent[nodeStart] != 0){
                nodeStart = parent[nodeStart];
            }
            if(parent[nodeEnd] != 0){
                nodeEnd = parent[nodeEnd];
            }
        }
        result[0] = nodeStart;
        result[1] = nodeEnd;
    }
}

class Edge{
    int begin;
    int end;
    int weight;

    public Edge() {
    }

    public Edge(int begin, int end, int weight) {
        this.begin = begin;
        this.end = end;
        this.weight = weight;
    }
}
