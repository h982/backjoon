import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기14499 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[N][];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(input.readLine());
            int[] temp = new int[M];
            for(int j = 0; j < M; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            map[i] = temp;
        }
        operations = new int[k];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < k; i++){
            operations[i] = Integer.parseInt(st.nextToken());
        }
        dice = new int[6];
        rollDice(x, y, k);
        System.out.print(output);
    }
    static int N, M;
    static int[][] map;
    static int[] operations;
    static int[] dice;
    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};
    static void rollDice(int x, int y, int k){
        for(int i = 0; i < k; i++){
            int oper = operations[i];
            int nr = x + dr[oper];
            int nc = y + dc[oper];
            if(!isIn(nr, nc))
                continue;
            int temp = 0;
            if(oper == 1){
                temp = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[0];
            }else if(oper == 2){
                temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[2];
                dice[2] = dice[0];
            }else if(oper == 3){
                temp = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[4];
                dice[4] = dice[0];
            }else if(oper == 4){
                temp = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[3];
                dice[3] = dice[0];
            }
            if(map[nr][nc] == 0){
                dice[0] = temp;
                map[nr][nc] = temp;
            }else{
                dice[0] = map[nr][nc];
                map[nr][nc] = 0;
            }
            output.append(dice[5] + "\n");
            x = nr;
            y = nc;
        }
    }
    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
