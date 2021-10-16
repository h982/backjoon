package 백준9월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위윷놀이 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        board = new int[21];
        for(int i = 1; i <= 20; i++)
            board[i] = 2 * i;
        horses = new int[4];
        dices = new int[10];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < 10; i++){
            dices[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(max);
    }
    static int[] board;
    static int[] horses;
    static int[] dices;
    static int max;
    static int[] shortcut = {0,2,3,4,11,6,4,8,9,4,11,12,13,Integer.MAX_VALUE};
    static int[] point = {0, 13,16,19,25,22,24,28,17,26,30,35,40,0};
    static void dfs(int cnt, int sum){
        if(cnt == 10){
            if(sum > max) {
                System.out.println(max);
                System.out.println(Arrays.toString(horses));
                max = sum;
            }
            return;
        }
        int move = dices[cnt];
        for(int i = 0; i < 4; i++){
            if(horses[i] == Integer.MAX_VALUE)
                continue;
            dfs(cnt + 1, sum + moveHourse(i, move));
        }
    }
    static int moveHourse(int idx, int move){

        if(horses[idx] >= 100){
            int next = horses[idx]/100;
            for(int i = 0; i < move; i++){
                next = shortcut[next];
                if(next == Integer.MAX_VALUE){
                    horses[idx] = Integer.MAX_VALUE;
                    return 0;
                }
            }
            horses[idx] = next*100;
            return point[next];
        }

        int next = horses[idx] + move;
        if(next > 20){
            horses[idx] = Integer.MAX_VALUE;
            return 0;
        }
        if((next+1)%5 == 0 && next != 19){
            int val = (next+1)/5;
            if(val == 1){
                horses[idx] = 100;
                return 23;
            }
            if(val == 2){
                horses[idx] = 500;
                return 42;
            }
            if(val == 3){
                horses[idx] = 700;
                return 58;
            }
        }
        horses[idx] = next;
        return board[next];
    }
}
