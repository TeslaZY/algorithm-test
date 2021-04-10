package zy;

import java.util.*;


public class MinimumPathCoverage {
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int[] match_list;
    public static int[] path_list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new List[n + 1];
        visited = new boolean[n + 1];
        match_list = new int[n + 1];
        path_list = new int[n + 1];
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            List<Integer> list;
            if((list = graph[x]) == null){
                list = new ArrayList<>();
            }
            list.add(y);
            graph[x] = list;
        }
        Arrays.fill(visited, false);
        Arrays.fill(match_list, -1);
        Arrays.fill(path_list, -1);

        for(int i = 1 ; i <= n; i++){
            Arrays.fill(visited, false);
            fineAgumentPath(i);
        }

        boolean[] isPrint = new boolean[n + 1];
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(isPrint[i]){
                continue;
            }
            int t = i;
            while(match_list[t] != -1){
                t = match_list[t];
            }
            while(t != -1){
                System.out.print(t);
                System.out.print(" ");
                isPrint[t] = true;
                t = path_list[t];
            }
            System.out.println();
            count++;
        }
        System.out.println(count);
    }


    public static boolean fineAgumentPath(int x){
        List<Integer> list = graph[x];
        if(list == null){
            return true;
        }
        for(int i : list){
            if(!visited[i]){
                visited[i] = true;
                if(match_list[i] == -1 || fineAgumentPath(match_list[i])){
                    match_list[i] = x;
                    path_list[x] = i;
                    return true;
                }
            }
        }
        return false;
    }

}