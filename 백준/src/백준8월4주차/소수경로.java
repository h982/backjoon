package 백준8월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소수경로 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        possible = new boolean[10000];
        for(int i = 2; i < 5000; i++){
            if(possible[i])
                continue;
            int idx = i * 2;
            while(idx < 10000){
                possible[idx] = true;
                idx += i;
            }
        }
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int ans = bfs(start, dest);
            output.append(ans==-1?"Impossible":ans).append("\n");
        }
        System.out.println(output);
    }
    static boolean[] possible;
    static int bfs(int start, int dest){
        boolean[] isVisited = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int temp = queue.poll();
                if(temp == dest){
                    return count;
                }
                int loc = 1;
                for(int j = 0; j < 4; j++){
                    int check = temp;
                    int num = temp / loc;
                    for(int k = 0; k < 10; k++){
                       check += loc;
                       num++;
                       if(num % 10 == 0){
                           check -= loc*10;
                       }
                       if(check >= 1000 && !possible[check] && !isVisited[check]){
                           isVisited[check] = true;
                           queue.add(check);
                       }
                    }
                    loc *= 10;
                }
            }
            count++;
        }
        return -1;
    }
}
