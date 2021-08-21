import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이모티콘 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        S = Integer.parseInt(input.readLine());
        System.out.println(bfs());
    }
    static int S;
    static int bfs(){

        PriorityQueue<ClipBoard> pq = new PriorityQueue<>(new Comparator<ClipBoard>() {
            @Override
            public int compare(ClipBoard o1, ClipBoard o2) {
                return o1.time - o2.time;
            }
        });
        pq.add(new ClipBoard(0,1, 0));
        boolean[][] isVisited = new boolean[2001][1001];
        isVisited[1][0] = true;
        int ans = 0;
        while(!pq.isEmpty()){
            ClipBoard now = pq.poll();
            if(now.count == S){
                ans = now.time;
                break;
            }
            if(now.count >= 1 && !isVisited[now.count-1][now.clip_count]){
                isVisited[now.count-1][now.clip_count] = true;
                pq.add(new ClipBoard(now.time+1, now.count-1, now.clip_count));
            }
            if(now.clip_count != 0 && isIn(now.count+now.clip_count, now.clip_count) && !isVisited[now.count+now.clip_count][now.clip_count]){
                isVisited[now.count+now.clip_count][now.clip_count] = true;
                pq.add(new ClipBoard(now.time+1, now.count + now.clip_count, now.clip_count));
            }
            if(isIn(now.count, now.count) && !isVisited[now.count][now.count]) {
                isVisited[now.count][now.count] = true;
                pq.add(new ClipBoard(now.time + 1, now.count, now.count));
            }
        }

        return ans;
    }
    static boolean isIn(int cnt, int clip){
        return cnt <= 2000 && clip <= 1000;
    }

    static class ClipBoard{
        int time;
        int count;
        int clip_count;
        public ClipBoard(int time, int count, int clip_count){
            this.time = time;
            this.count = count;
            this.clip_count = clip_count;
        }
    }
}
