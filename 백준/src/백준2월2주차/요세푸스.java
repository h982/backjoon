package 백준2월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 요세푸스 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer str = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());

        List<Integer> yosepus = new LinkedList<>();
        for(int i = 1; i <= N; i++)
            yosepus.add(i);
        int temp = K-1;

        output.append("<");
        while(yosepus.size() > 0){
            temp = temp % yosepus.size();
            output.append(yosepus.remove(temp) +", ");
            temp += K - 1;
        }
        output.setLength(output.length()-2);
        output.append(">");

        System.out.println(output);
    }
}
