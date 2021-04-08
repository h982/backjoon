package 백준4월1주차;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class 포도주시식2156 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "6\n" +
            "10\n" +
            "13\n" +
            "9\n" +
            "8\n" +
            "1";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        int[] alchols = new int[N];
        for(int i = 0; i < N; i++)
            alchols[i] = Integer.parseInt(input.readLine());

        if(N == 1){
            System.out.println(alchols[0]);
            return;
        }else if(N == 2){
            System.out.println(alchols[0] + alchols[1]);
            return;
        }

        int[][] alchol_sum = new int[N][2];
        alchol_sum[0][0] = alchols[0];
        alchol_sum[1][0] = alchols[1];
        alchol_sum[1][1] = alchols[0] + alchols[1];
        alchol_sum[2][0] = alchols[2] + alchols[0];
        alchol_sum[2][1] = alchols[2] + alchol_sum[1][0];
        for(int i = 3; i < N; i++){
            alchol_sum[i][0] = alchols[i] + Math.max(Math.max(alchol_sum[i-2][0] , alchol_sum[i-2][1]), alchol_sum[i-3][1]);
            alchol_sum[i][1] = alchols[i] + alchol_sum[i-1][0];
        }

        System.out.println(Math.max(Math.max(alchol_sum[N-1][0], alchol_sum[N-1][1]), alchol_sum[N-2][1]));
    }
}
