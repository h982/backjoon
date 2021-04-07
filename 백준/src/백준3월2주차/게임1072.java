package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 게임1072 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "100 53";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());

        int X = Integer.parseInt(str.nextToken());
        int Y = Integer.parseInt(str.nextToken());

        int left = 1;
        int right = X;
        int ans = -1;

        long now = ((long)100 * Y) / X;
        while(left <= right){
            int mid = (left + right) / 2;

            long temp = ((long)100 * (Y+mid)) / (X+mid);
            if( temp > now){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
