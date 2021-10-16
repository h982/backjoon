package 백준10월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 중량제한 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        islands = new Map[N+1];
        for(int i = 1; i <= N; i++){
            islands[i] = new HashMap<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(islands[a].containsKey(b) && islands[a].get(b) < c){
                islands[a].replace(b, c);
                islands[b].replace(a, c);
                continue;
            }
            islands[a].put(b, c);
            islands[b].put(a, c);
        }

        st = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        pq.add(new int[]{start, Integer.MAX_VALUE});
        boolean[] isVisited = new boolean[N+1];
        int ans = 0;
        for(int i = 0; i < N; i++){
            int next = 0;
            int weight = 0;
            while(!pq.isEmpty()){
                int[] temp = pq.poll();
                if(isVisited[temp[0]])
                    continue;
                next = temp[0];
                weight = temp[1];
                break;
            }

            if(next == end){
                ans = weight;
                break;
            }

            isVisited[next] = true;
            for(Map.Entry<Integer, Integer> entry: islands[next].entrySet()){
                if(isVisited[entry.getKey()])
                    continue;
                pq.add(new int[]{entry.getKey(), entry.getValue() < weight? entry.getValue():weight});
            }

        }

        System.out.println(ans);

    }
    static int N, M;
    static Map<Integer, Integer>[] islands;
}
