package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 동전0_11047 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "10 4200\n" +
            "1\n" +
            "5\n" +
            "10\n" +
            "50\n" +
            "100\n" +
            "500\n" +
            "1000\n" +
            "5000\n" +
            "10000\n" +
            "50000";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        int[] coins = new int[N];
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(input.readLine());
        }
        int idx = N-1;
        int count = 0;
        while(K > 0){
            if(K >= coins[idx]){
                K -= coins[idx];
                count++;
                continue;
            }
            idx--;
        }
        System.out.println(count);
    }
}
