import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 감소하는수 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        System.out.println(cal());
    }

    static int N;
    static List<String>[] st_list;
    static String cal(){
        String ans = "";
        st_list = new List[10];
        int count = 0;
        for(int i = 0; i < 10; i++){
            st_list[i] = new ArrayList<String>();
            st_list[i].add(new String(Integer.toString(i)));
            if(count == N){
                ans = st_list[i].get(0).toString();
            }
            count++;
        }

        out:for(int i = 1; i < 10; i++){
            List[] new_list = new List[10];
            new_list[0] = new ArrayList();
            for(int j = 1; j < 10; j++){
                new_list[j] = new ArrayList<String>();

                for(int k = 0; k < j; k++){
                    for(int l = 0; l < st_list[k].size(); l++){
                        if(count++ == N){
                            ans = j + st_list[k].get(l);
                            break out;
                        }
                        new_list[j].add(j + st_list[k].get(l));
                    }
                }
            }
            st_list = new_list;
        }
        if(ans.equals("")){
            ans = "-1";
        }
        return ans;
    }
}
