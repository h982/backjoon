import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs();
        }
        System.out.println(output);
    }
    static int A, B;
    static class Calc{
        int num;
        String oper;

        public Calc(int n, String op){
            this.num = n;
            this.oper = op;
        }
    }
    static void bfs(){
        Queue<Calc> queue = new LinkedList<>();
        Calc a = new Calc(A, "");
        queue.add(a);
        boolean[] visited = new boolean[10000];
        visited[a.num] = true;
        while(!queue.isEmpty()){
            Calc temp = queue.poll();
            if(temp.num == B){
                output.append(temp.oper + "\n");
                return;
            }

            int d = D(temp.num);
            if(!visited[d]){
                visited[d] = true;
                queue.add(new Calc(d, temp.oper + "D"));
            }
            d = S(temp.num);
            if(!visited[d]){
                visited[d] = true;
                queue.add(new Calc(d, temp.oper + "S"));
            }
            d = L(temp.num);
            if(!visited[d]){
                visited[d] = true;
                queue.add(new Calc(d, temp.oper + "L"));
            }
            d = R(temp.num);
            if(!visited[d]){
                visited[d] = true;
                queue.add(new Calc(d, temp.oper + "R"));
            }
        }
    }

    static int D(int num){
        return (num*2) % 10000;
    }
    static int S(int num){
        int ans = num - 1;
        if(ans < 0)
            return 9999;
        return ans;
    }
    static int L(int num){
        int ans = (num - (num/1000)*1000) * 10 + (num / 1000);
        return ans;
    }
    static int R(int num){
        int ans = num / 10 + (num % 10) * 1000;
        return ans;
    }
}
