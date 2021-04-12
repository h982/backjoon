package 백준4월3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퇴사14501 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(input.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(input.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        long[] ans = new long[N+2];
        for(int i = 1; i <= N; i++){
            ans[i] = Math.max(ans[i-1], ans[i]);
            if(i + T[i] <= N+1)
                ans[i + T[i]] = Math.max(ans[i + T[i]], ans[i] + P[i]);
        }
        ans[N+1] = Math.max(ans[N], ans[N+1]);
        System.out.println(ans[N+1]);
    }
}
