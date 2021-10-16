package 백준9월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좋은수열 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        sb = new StringBuilder();
        dfs(0);
        System.out.println(sb.toString());
    }
    static int N;
    static StringBuilder sb;
    static boolean dfs(int idx){
        if(idx == N){
            return true;
        }
        for(int i = 1; i <= 3; i++){
            sb.append(i);
            if(isOk()){
                if(dfs(idx + 1))
                    return true;
            }
            sb.setLength(sb.length()-1);
        }
        return false;
    }
    static boolean isOk(){
        int size = sb.length();
        for(int i = 1; i <= size/2; i++){
            int start = size - i;
            String a = sb.substring(start);
            String b = sb.substring(start-i ,start);

            if(a.equals(b))
                return false;
        }
        return true;
    }
}
