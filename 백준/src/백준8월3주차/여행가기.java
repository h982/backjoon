package 백준8월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 여행가기 {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        ways = new List[N+1];
        for(int i = 1; i <= N; i++)
            ways[i] = new ArrayList();

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 1; j <= N; j++){
                int way = Integer.parseInt(st.nextToken());
                if(way == 1)
                    ways[i].add(j);
            }
        }
        schedules = new HashSet<>();
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < M; i++){
            int temp = Integer.parseInt(st.nextToken());
            schedules.add(temp);
        }
        if(bfs())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    static int N, M;
    static List<Integer>[] ways;
    static Set<Integer> schedules;
    static boolean bfs(){
        boolean[] isVisited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int connect : ways[temp]){
                if(!isVisited[connect]){
                    isVisited[connect] = true;
                    queue.add(connect);
                }
            }
        }
        Iterator iter = schedules.iterator();
        boolean flag = isVisited[(int)iter.next()];
        while(iter.hasNext()){
            if(flag != isVisited[(int)iter.next()]){
                return false;
            }
        }
        return true;
    }
}
