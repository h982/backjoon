package 백준9월1주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K < 5){
            System.out.println(0);
            return;
        }

        words = new int[N][];
        for(int i = 0; i < N; i++){
            String str = input.readLine();
            int temp = 0;
            for(int j = 0; j < str.length(); j++){
                char val = str.charAt(j);
                temp |= (1 << (val - 'a'));
            }
            words[i] = new int[]{temp, cal(temp)};
        }

        int start = 0;
        selected = new boolean[26];
        for(int i = 0; i < 5; i++){
            int temp = basic[i] -'a';
            start |= 1<<temp;
            selected[temp] = true;
        }
        max_val = 0;
        comb(start, 5, 0);
        System.out.println(max_val);
    }
    final static char[] basic = new char[]{'a', 'c', 'n', 't', 'i'};
    // anta tica -> a,c,n,t,i
    static int N, K;
    static int[][] words;
    static boolean[] selected;
    static int max_val;
    static void comb(int word, int cnt, int idx){
        if(cnt == K){
            readWords(word);
            return;
        }
        for(int i = idx; i < 26; i++){
            if(!selected[i]){
                selected[i] = true;
                comb(word|(1<<i), cnt+1, i+1);
                selected[i] = false;
            }
        }
    }

    static void readWords(int word){
        int sum = 0;
        for(int i = 0; i < words.length; i++){
            int test = words[i][0];
            int cal = cal(word & test);
            if(cal == words[i][1])
                sum++;
        }
        if(sum > max_val)
            max_val = sum;
    }

    static int cal(int word){
        int sum = 0;
        for(int i = 0; i < 26; i++){
            sum += (word>>i) & 1;
        }
        return sum;
    }
}