package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 햄버거분배19941 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "20 2\n" +
            "HHHHHPPPPPHPHPHPHHHP";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        char[] table = input.readLine().toCharArray();

        int sum = 0;
        for(int i = 0; i < N; i++){
            if(table[i] == 'P'){
                for(int j = i - K; j <= i + K; j++){
                    if(j < 0 || j >= N)
                        continue;
                    if(table[j] == 'H'){
                        table[j] = 'X';
                        sum++;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
