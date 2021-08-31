package 백준8월4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숨바꼭질4 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Loc ans = bfs();
        System.out.println(ans.cnt);
        System.out.println(ans.sb.toString());
    }

    static int N, K;

    static Loc bfs() {
        PriorityQueue<Loc> queue = new PriorityQueue<>((o1, o2) -> o1.cnt-o2.cnt);
        queue.add(new Loc(0, "", N));
        boolean[] isVisited = new boolean[200001];
        while (!queue.isEmpty()) {
            Loc temp = queue.poll();
            if (temp.loc == K) {
                return temp;
            }
            if(K < temp.loc){
                int cnt = temp.cnt + temp.loc - K;
                StringBuilder sb = new StringBuilder(temp.sb.toString());
                boolean flag = true;
                for(int i = temp.loc-1; i > K; i--){
                    if(isVisited[i]){
                        flag = false;
                        break;
                    }
                    sb.append(i).append(" ");
                }
                if(flag)
                    queue.add(new Loc(cnt, sb.toString(), K));
            }else {
                int check = temp.loc - 1;
                if (check >= 0 && !isVisited[check]) {
                    isVisited[check] = true;
                    queue.add(new Loc(temp.cnt + 1, temp.sb.toString(), check));
                }
                check = temp.loc + 1;
                if (check <= 100000 && !isVisited[check]) {
                    isVisited[check] = true;
                    queue.add(new Loc(temp.cnt + 1, temp.sb.toString(), check));
                }
                check = temp.loc * 2;
                if (check <= 200000 && !isVisited[check]) {
                    isVisited[check] = true;
                    queue.add(new Loc(temp.cnt + 1, temp.sb.toString(), check));
                }
            }
        }
        return null;
    }

    static class Loc {
        int cnt;
        int loc;
        StringBuilder sb;

        public Loc(int cnt, String str, int loc) {
            this.cnt = cnt;
            this.sb = new StringBuilder(str);
            this.sb.append(loc).append(" ");
            this.loc = loc;
        }
    }
}
