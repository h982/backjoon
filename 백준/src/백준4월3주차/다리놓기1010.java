package 백준4월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기1010 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());

        factor = new long[31][31];
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(M == N) {
                output.append(1+"\n");
                continue;
            }
            long ans = comb(M, N);
            output.append(ans+"\n");
        }
        System.out.println(output);
    }
    static long[][] factor;
    static long comb(int n, int r){
        if(n == r || r == 0){
            return 1;
        }
        if(factor[n][r] != 0)
            return factor[n][r];
        return factor[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }
}
