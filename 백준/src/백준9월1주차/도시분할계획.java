package 백준9월1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 도시분할계획 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Map[N + 1];
        for(int i = 1; i <= N; i++){
            edges[i] = new HashMap<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[a].put(b, c);
            edges[b].put(a, c);
        }
        System.out.println(prim());
    }
    static int N, M;
    static Map<Integer, Integer>[] edges;
    static int prim(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[]{1, 0});
        boolean[] isVisited = new boolean[N+1];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++){
            int[] loc = {-1, -1};
            while (!pq.isEmpty()){
                loc = pq.poll();
                if(isVisited[loc[0]])
                    continue;
                break;
            }
            sum += loc[1];
            if(loc[1] > max)
                max = loc[1];
            isVisited[loc[0]] = true;
            for (Map.Entry<Integer, Integer> entry : edges[loc[0]].entrySet()){
                if(!isVisited[entry.getKey()]){
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        return sum - max;
    }
}
