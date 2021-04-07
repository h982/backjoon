package 백준3월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 상근이의여행9372 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "3 3\n" +
            "1 2\n" +
            "2 3\n" +
            "1 3\n" +
            "5 4\n" +
            "2 1\n" +
            "2 3\n" +
            "4 3\n" +
            "4 5";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str;
        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            str = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());
            map = new List[N+1];

            for(int i = 0; i < M; i++){
                str = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(str.nextToken());
                int b = Integer.parseInt(str.nextToken());
                map[a].add(b);
                map[b].add(a);
            }
            visited = new boolean[N+1];
        }
    }
    static List<Integer>[] map;
    static boolean[] visited;
    static int count;
    static void goTravel(int loc){

    }
}
