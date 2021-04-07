package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 유성10703 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer str;
    static String src = "5 6\n" +
            ".XXXX.\n" +
            "...X..\n" +
            "......\n" +
            "#..###\n" +
            "######";

    static int R, S;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        str = new StringTokenizer(input.readLine());
        int R = Integer.parseInt(str.nextToken());
        int S = Integer.parseInt(str.nextToken());
        map = new char[R][];
        for(int i = 0; i < R; i++){
            map[i] = input.readLine().toCharArray();
        }


    }

    static void down(){

    }
}
