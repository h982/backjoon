import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 숫자고르기2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        arr = new int[N+1];
        int same_idx = 0;
        boolean[] visited = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(input.readLine());
            if(i == arr[i]) {
                visited[i] = true;
                same_idx++;
            }
        }
        int ans = same_idx;
        for(int i = 1; i < N; i++){
            if(!visited[i] && arr[i] != i) {
                int next_idx = arr[i];
                boolean flag = false;
                visited[i] = true;
                int count = 1;
                List<Integer> indexs = new ArrayList<>();
                indexs.add(i);
                while (!visited[next_idx]){
                    count++;
                    indexs.add(next_idx);
                    visited[next_idx] = true;
                    int next = arr[next_idx];
                    if(next == i){
                        ans += count;
                        flag = true;
                        break;
                    }
                    if(visited[next]){
                        break;
                    }
                    next_idx = next;
                }
                if(!flag){
                    for(int idx : indexs){
                        visited[idx] = false;
                    }
                }
            }
        }
        System.out.println(ans);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i < N; i++){
            if(visited[i]){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
    static int N;
    static int[] arr;
}