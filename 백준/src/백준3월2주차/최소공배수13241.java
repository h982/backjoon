package 백준3월2주차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class 최소공배수13241 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static String src = "121 199";

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));

        StringTokenizer str = new StringTokenizer(input.readLine());
        A = Long.parseLong(str.nextToken());
        B = Long.parseLong(str.nextToken());

        System.out.println(search(A,B));
    }
    static Long A, B;
    static Long search(Long a, Long b){
        Long ret = 1l;
        HashMap<Long, Integer> a_map = seperate(a);
        HashMap<Long, Integer> b_map = seperate(b);
        Set<Long> a_keys = a_map.keySet();
        for(Long key : a_keys){
            if(b_map.containsKey(key)){
                int recur_times =  Math.max(a_map.get(key), b_map.get(key));
                for(int i = 0; i < recur_times; i++){
                    ret *= key;
                }
                b_map.remove(key);
            }
            else{
                for(int i = 0; i < a_map.get(key); i++){
                    ret *= key;
                }
            }
        }
        Set<Long> b_keys = b_map.keySet();
        for(Long key: b_keys){
            for(int i = 0; i < b_map.get(key); i++){
                ret *= key;
            }
        }
        return ret;
    }
    static HashMap<Long, Integer> seperate(Long a){
        HashMap<Long, Integer> map = new HashMap<>();

        Long idx = 2l;
        while(a != 1){
            if(a % idx == 0){
                a /= idx;
                if(!map.containsKey(idx)){
                    map.put(idx, 1);
                    continue;
                }
                map.replace(idx, map.get(idx) + 1);
            }
            else{
                idx++;
            }
        }
        return map;
    }
}
