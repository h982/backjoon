package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수리공항승1449 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4 2\n" +
            "1 2 100 101";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        N = Integer.parseInt(str.nextToken());
        L = Integer.parseInt(str.nextToken());

        leak = new int[N];
        str = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            leak[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(leak);

        int tape = 0;
        int count = 0;
        for(int point: leak){
            if(point <= tape)
                continue;

            tape = point + L - 1;
            count++;
        }
        System.out.println(count);
    }
    static int N, L;
    static int[] leak;
}
