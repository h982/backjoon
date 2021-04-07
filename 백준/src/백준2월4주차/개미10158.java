package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 개미10158 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6 4\n" +
            "4 1\n" +
            "8";

    public static void main(String[] args)throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        int width = Integer.parseInt(str.nextToken());
        int height = Integer.parseInt(str.nextToken());

        str = new StringTokenizer(input.readLine());
        int p = Integer.parseInt(str.nextToken());
        int q = Integer.parseInt(str.nextToken());

        int t = Integer.parseInt(input.readLine());

        int w_dist = (p+t) % (2*width);
        int h_dist = (q+t) % (2*height);

        if(w_dist > width){
            w_dist = 2 * width - w_dist;
        }
        if(h_dist > height){
            h_dist = 2 * height - h_dist;
        }

        System.out.println(w_dist + " " + h_dist);
    }
}
