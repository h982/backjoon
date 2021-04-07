package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class GCD합9613 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "3\n" +
            "4 10 20 30 40\n" +
            "3 7 5 12\n" +
            "3 125 15 25";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int T = Integer.parseInt(input.readLine());
        StringTokenizer str;
        for(int test_case = 1; test_case <= T; test_case++){
            str = new StringTokenizer(input.readLine());
            N = Integer.parseInt(str.nextToken());
            arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(str.nextToken());
            }

            selected = new int[2];
            sum = 0;
            comb_GCD(0,0);
            output.append(sum + "\n");
        }
        System.out.println(output);
    }

    static int N, sum;
    static int[] arr;
    static int[] selected;
    static void comb_GCD(int cnt, int idx){
        if(cnt == 2){
            if(selected[0] > selected[1])
                sum += calculateGCD(selected[0], selected[1]);
            else
                sum += calculateGCD(selected[1], selected[0]);
            return;
        }

        for(int i = idx; i < N; i++){
            selected[cnt] = arr[i];
            comb_GCD(cnt+1, i+1);
        }
    }
    static int calculateGCD(int a, int b){
        // a > b
        int temp;
        while(b > 0){
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
