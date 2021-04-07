package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열11053 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "6\n" +
            "10 20 10 30 20 50";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        int N = Integer.parseInt(input.readLine());
        list = new ArrayList<>();

        StringTokenizer str = new StringTokenizer(input.readLine());
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(str.nextToken());
            if(list.contains(temp))
                continue;
            list.add(temp);
        }
        Collections.sort(list);

        max_len = 1;
        for(int i = 0; i < list.size()-1; i++){
            search(i);
        }
    }

    static int max_len;
    static List<Integer>list;
    static void search(int start){
        if(list.size() - start - 1 < max_len)
            return;

        int now = start;
        for(int next = start+1; next < list.size(); next++){
            int len = 1;
            int diff = list.get(next) - list.get(start);
            int temp = list.get(next) + diff;

            len++;
            int idx = next + 1;
            while(idx < list.size()){
                int val = list.get(next+1) - temp;
                if(val == diff){
                    len++;
                    idx++;
                    temp += diff;
                }else if(val > diff){
                    break;
                }else{
                    idx++;
                }
            }
            if(len > max_len)
                max_len = len;
        }
    }
}
