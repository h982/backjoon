import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 톱니바퀴 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        gears = new int[4][];
        StringTokenizer st;
        for(int i = 0; i < 4; i++){
            String in = input.readLine();
            int[] temp = new int[8];
            for(int j = 0; j < 8; j++)
                temp[j] = in.charAt(j) - '0';
            gears[i] = temp;
        }
        int k = Integer.parseInt(input.readLine());
        isRotate = new boolean[4];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(input.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            Arrays.fill(isRotate, false);
            isRotate[num] = true;
            rotateGear(num, dir);
        }
        int ans = 0;
        for(int i = 0; i < 4; i++){
            if(gears[i][0] == 1){
                ans += 1<<i;
            }
        }
        System.out.println(ans);
    }
    static int[][] gears;
    static boolean[] isRotate;
    static void rotateGear(int num, int dir){
        if(num > 0){
            if(!isRotate[num-1] && gears[num][6] != gears[num-1][2]){
                isRotate[num-1] = true;
                rotateGear(num-1, -dir);
            }
        }
        if(num < 3){
            if(!isRotate[num+1] && gears[num][2] != gears[num+1][6]){
                isRotate[num+1] = true;
                rotateGear(num+1, -dir);
            }
        }

        if(dir == 1){
            int temp = gears[num][0];
            for(int i = 7; i > 0; i--){
                gears[num][(i+1)%8] = gears[num][i];
            }
            gears[num][1] = temp;
        }
        if(dir == -1){
            int temp = gears[num][7];
            for(int i = 0; i < 8; i++){
                gears[num][(i+7)%8] = gears[num][i];
            }
            gears[num][6] = temp;
        }


    }
}
