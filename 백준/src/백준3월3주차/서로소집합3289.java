package 백준3월3주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서로소집합3289 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "7 8\n" +
            "0 1 3\n" +
            "1 1 7\n" +
            "0 7 6\n" +
            "1 7 1\n" +
            "0 3 7\n" +
            "0 4 2\n" +
            "0 1 1\n" +
            "1 1 1\n" +
            "7 8\n" +
            "0 1 3\n" +
            "1 1 7\n" +
            "0 7 6\n" +
            "1 7 1\n" +
            "0 3 7\n" +
            "0 4 2\n" +
            "0 1 1\n" +
            "1 1 1";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer str = new StringTokenizer(input.readLine());

            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());

            parents = new int[N+1];
            for(int i = 1; i < N+1; i++)
                parents[i] = i;

            output.append("#" + test_case + " ");
            for(int i = 0; i < M; i++){
                str = new StringTokenizer(input.readLine());

                int act = Integer.parseInt(str.nextToken());
                int a = Integer.parseInt(str.nextToken());
                int b = Integer.parseInt(str.nextToken());
                if(act == 0){
                    union(a, b);
                    System.out.println(Arrays.toString(parents));
                    continue;
                }
                output.append((isSameParent(a,b)? "1": "0"));
            }
            output.append("\n");
        }
        System.out.println(output);
    }
    static int[] parents;
    static int union(int a, int b){
        if(isSameParent(a,b))
            return parents[a];

        if(parents[b] == b){
            parents[b] = parents[a];
            return parents[b];
        }
        parents[b] = union(a, parents[b]);
        return parents[b];
    }
    static int find(int a){
        if(parents[a] == a)
            return a;
        return find(parents[a]);
    }
    static boolean isSameParent(int a, int b){
        if(find(a) == find(b))
            return true;
        return false;
    }
}
