package 백준3월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class generationOfTribbles9507 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "8\n" +
            "0\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "30\n" +
            "67";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int T = Integer.parseInt(input.readLine());
        pibonnachi = new long[68];
        for(int i = 0; i < 2; i++)
            pibonnachi[i] = 1;
        pibonnachi[2] = 2;
        pibonnachi[3] = 4;
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(input.readLine());
            output.append(calcPibo(N) + "\n");
        }
        System.out.println(output);
    }
    static long[] pibonnachi;
    static long calcPibo(int n){
        if(pibonnachi[n] != 0){
            return pibonnachi[n];
        }
        pibonnachi[n] = calcPibo(n-1) + calcPibo(n-2) + calcPibo(n-3) + calcPibo(n-4);
        return pibonnachi[n];
    }
}
