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
                if(n==1) {System.out.println(0);return;}
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
            for(int i=0;i<m;i++){
                int node1 = find(parent,edges[i].begin);
                int node2 = find(parent,edges[i].end);
                if(node1 != node2){
                    parent[node1] = node2;
                    result_weight += edges[i].weight;
                }
            }

            System.out.println(result_weight);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int find(int[] parent, int node){
        while(parent[node]>0){
            node = parent[node];
        }
        return node;
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
