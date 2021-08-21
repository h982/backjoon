import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨1107 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        M = Integer.parseInt(input.readLine());
        remote_control = new boolean[10];
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for (int i = 0; i < M; i++) {
                int button = Integer.parseInt(st.nextToken());
                remote_control[button] = true;
            }
        }
        // +, - 로만 이동
        int ans = Math.abs(N-100);
        // 한번에 이동 가능?
        int once = canMove(N);
        if(once != -1){
            ans = Math.min(ans, once);
        }

        int count = 1;
        boolean flag = true;
        while (flag && count < ans) {
            int plus = N + count;
            int minus = N - count;
            int plus_move = canMove(plus);
            int minus_move = canMove(minus);
            if(plus_move != -1){
                ans = Math.min(ans, plus_move + count);
                flag = false;
            }
            if(minus_move != -1){
                ans = Math.min(ans, minus_move + count);
                flag = false;
            }
            count++;
        }
        System.out.println(ans);
    }
    static int N, M;
    static boolean[] remote_control;
    static int canMove(int a){
        if(a < 0)
            return -1;
        String num = String.valueOf(a);
        for(int i = 0; i < num.length(); i++){
            if(remote_control[num.charAt(i) - '0'])
                return -1;
        }
        return num.length();
    }
}
