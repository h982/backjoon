package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 토너먼트1057 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "65536 1000 35000";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int kim = Integer.parseInt(str.nextToken());
        int im = Integer.parseInt(str.nextToken());

        int count = 1;
        while(true){
            if(Math.abs(kim - im) == 1 && (Math.min(kim,im) % 2 == 1))
                break;
            count++;
            if(kim % 2 == 1)
                kim = (kim+1) / 2;
            else
                kim /= 2;

            if(im % 2 == 1)
                im = (im+1) / 2;
            else
                im /= 2;
        }

        System.out.println(count);
    }
}
