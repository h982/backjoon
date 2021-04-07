package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 자리배정10157 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "7 6\n" +
            "22";
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(str.nextToken());
        int C = Integer.parseInt(str.nextToken());
        long k = Long.parseLong(input.readLine());

        if(k > C * R){
            System.out.println(0);
        }

        else{

            int K = (int)k;

            int[] loc = new int[]{1,0};
            while(K > 0){
                if(K > C) {
                    loc[1] += C;
                    K -= C;
                }
                else{
                    loc[1] += K;
                    break;
                }
                if(K > --R) {
                    loc[0] += R;
                    K -= R;

                }
                else{
                    loc[0] += K;
                    break;
                }
                if(K > --C) {
                    loc[1] -= C;
                    K -= C;

                }
                else{
                    loc[1] -= K;
                    break;
                }
                if(K > --R) {
                    loc[0] -= R;
                    K -= R;

                }
                else{
                    loc[0] -= K;
                    break;
                }
                C--;
            }
            System.out.println(loc[0]+ " " + loc[1]);
        }
    }
}
