package 백준2월4주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 방배정13300 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "16 2\n" +
            "1 1\n" +
            "0 1\n" +
            "1 1\n" +
            "0 2\n" +
            "1 2\n" +
            "0 2\n" +
            "0 3\n" +
            "1 3\n" +
            "1 4\n" +
            "1 3\n" +
            "1 3\n" +
            "0 6\n" +
            "1 5\n" +
            "0 5\n" +
            "1 5\n" +
            "1 6";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        StringTokenizer str = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        int rooom_num = 0;
        int[] students_w = new int[6];
        int[] students_m = new int[6];
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(input.readLine());
            int sex = Integer.parseInt(str.nextToken());
            int year = Integer.parseInt(str.nextToken());
            if(sex == 0)
                students_w[--year]++;
            else
                students_m[--year]++;
        }
        for(int i = 0; i < 6; i++){
            rooom_num += students_w[i]/K;
            rooom_num += students_m[i]/K;
            if(students_w[i] % K > 0)
                rooom_num++;
            if(students_m[i] % K > 0)
                rooom_num++;
        }
        System.out.println(rooom_num);
    }
}
