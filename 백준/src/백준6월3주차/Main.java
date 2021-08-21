import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        new Main().result();
    }

    public void result() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numN = Integer.parseInt(st.nextToken());
        int numK = Integer.parseInt(st.nextToken());

        long sum[][] = new long[numK+1][numN+1];

        // K = 1
        for (int i = 0; i <= numN ; i++) {
            sum[1][i] = 1;
        }
        // N != 0
        for (int K = 1; K <= numK ; K++) {
            for (int N = 0; N <= numN ; N++) {
                for (int L = N; L >=0 ; L--) {
                    sum[K][N] += sum[K - 1][N - L];
                    sum[K][N] %= 1000000000;
                }
            }
        }
        System.out.println(sum[numK][numN]);
    }
}