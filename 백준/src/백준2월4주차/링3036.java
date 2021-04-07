package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 링3036 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "4\n" +
            "12 3 8 4";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());

        int[] rings = new int[N];
        StringTokenizer str = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            rings[i] = Integer.parseInt(str.nextToken());
        }
        for(int i = 1; i < N; i++)
            makeBunSu(rings[0], rings[i]);

        System.out.println(output);
    }
    static void makeBunSu(int A, int B){
        int GCD = makeGCD(A, B);
        output.append((A/GCD) + "/" + (B/GCD) + "\n");
    }
    static int makeGCD(int A, int B){
        int a = Math.max(A, B);
        int b = Math.min(A, B);
        while(b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
