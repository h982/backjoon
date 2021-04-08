package 백준4월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM7560 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            minCnt = Integer.MAX_VALUE;
            search(A, 0);
            output.append("#" + test_case + " " + (minCnt==Integer.MAX_VALUE?-1:minCnt+1) + "\n");
        }
        System.out.println(output);
    }
    static int A, B, minCnt;
    static void search(int val, int cnt){
        if(val > B)
            return;
        if(val == B){
            minCnt = Math.min(cnt, minCnt);
            return;
        }

        search(val * 2, cnt + 1);
        search(val * 10 + 1, cnt + 1);

    }
}
