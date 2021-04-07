package 백준3월1주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 패션왕신해빈9375 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "2\n" +
            "3\n" +
            "hat headgear\n" +
            "sunglasses eyewear\n" +
            "turban headgear\n" +
            "3\n" +
            "mask face\n" +
            "sunglasses face\n" +
            "makeup face";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            int N = Integer.parseInt(input.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();
            StringTokenizer str;
            for(int i = 0; i < N; i++){
                str = new StringTokenizer(input.readLine());
                str.nextToken();
                String key = str.nextToken();
                if(!clothes.containsKey(key)){
                    clothes.put(key, 1);
                    continue;
                }
                clothes.put(key, clothes.get(key) + 1);
            }

            Iterator iter = clothes.values().iterator();

            int sum = 1;
            while(iter.hasNext()){
                sum *= (int)iter.next() + 1;
            }
            output.append((sum-1) + "\n");
        }
        System.out.println(output);
    }
}
