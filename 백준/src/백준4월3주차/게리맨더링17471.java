package 백준4월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class 게리맨더링17471 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "2 3 4 5 6 7\n" +
            "2 2 3\n" +
            "2 1 3\n" +
            "2 1 2\n" +
            "2 5 6\n" +
            "2 4 6\n" +
            "2 4 5";


    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        population = new int[N+1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        total_sum = 0;
        for(int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            total_sum += population[i];
        }
        map = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)
            map[i] = new ArrayList<Integer>();
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(input.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j= 0; j < cnt; j++)
                map[i].add(Integer.parseInt(st.nextToken()));
        }
        visited = new boolean[N+1];
        min = Integer.MAX_VALUE;
        dfs(1,0, 0);


        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }
    static int N;
    static int[] population;
    static List<Integer>[] map;
    static int min, total_sum;
    static boolean[] visited;
    static void dfs(int idx, int cnt, int sum){
        if(chk1() && chk2()) {
            int diff = Math.abs(total_sum - sum * 2);
            if (diff < min) {
                min = diff;
            }
        }else if(cnt == N)
            return;

        for(int i = idx; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, cnt+1, sum + population[i]);
                visited[i] = false;
            }
        }
    }

    static boolean chk1(){
        int start = 0;
        boolean[] chkArr = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                chkArr[i] = true;
                start = i;
            }
        }
        if(start == 0)
            return false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            chkArr[temp] = false;
            for(int next: map[temp]){
                if(chkArr[next]){
                    queue.add(next);
                }
            }
        }
        for(boolean ok : chkArr){
            if(ok)
                return false;
        }
        return true;
    }

    static boolean chk2(){
        int start = 0;
        boolean[] chkArr = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            if(visited[i]) {
                chkArr[i] = true;
                start = i;
            }
        }
        if(start == 0)
            return false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            chkArr[temp] = false;
            for(int next: map[temp]){
                if(chkArr[next]){
                    queue.add(next);
                }
            }
        }
        for(boolean ok : chkArr){
            if(ok)
                return false;
        }
        return true;
    }
}
