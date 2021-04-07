package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;

public class 시리얼번호1431 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "5\n" +
            "145\n" +
            "145C\n" +
            "ABC\n" +
            "AB\n" +
            "Z321";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        String[] serial = new String[N];
        for(int i = 0; i < N; i++){
            serial[i] = input.readLine();
        }
        Arrays.sort(serial, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length())
                    return o1.length() - o2.length();

                int sum_1 = 0, sum_2 = 0;
                for(int i = 0; i < o1.length(); i++){
                    if(Character.isDigit(o1.charAt(i)))
                        sum_1 += o1.charAt(i) - '0';
                    if(Character.isDigit(o2.charAt(i)))
                        sum_2 += o2.charAt(i) - '0';
                }
                if(sum_1 != sum_2)
                    return sum_1 - sum_2;

                return o1.compareTo(o2);
            }
        });

        for(String a : serial){
            output.append(a + "\n");
        }
        System.out.println(output);
    }
}
