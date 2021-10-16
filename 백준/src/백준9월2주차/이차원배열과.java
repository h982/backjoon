package 백준9월2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.*;

public class 이차원배열과 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());
        map = new int[100][100];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(calc());
    }
    static int R, C ,K;
    static int[][] map;
    static int calc(){
        for(int i = 0; i <= 100; i++){
//            System.out.println(i +" 번째");
            if(isEnd()){
                return i;
            }
            int col_size = 0;
            out:for(int j = 0; j < 100; j++){
                if(map[0][j] == 0){
                    for(int k = 0; k < 100; k++){
                        if(map[k][j] == 0)
                            continue;
                        continue out;
                    }
                    col_size = j;
                    break;
                }
            }
            int row_size = 0;
            out:for(int j = 0; j < 100; j++){
                if(map[j][0] == 0){
                    for(int k = 0; k < 100; k++){
                        if(map[j][k] == 0)
                            continue;
                        continue out;
                    }
                    row_size = j;
                    break;
                }
            }
            if(row_size >= col_size) {
                r(row_size);
                continue;
            }
            c(col_size);
        }
        return -1;
    }
    static boolean isEnd(){
        return map[R][C] == K;
    }
    static void c(int col){
        for(int i = 0; i < col; i++){
//            System.out.println("i :" + i);
            Map<Integer, Integer> vals = new HashMap<>();
            for(int j = 0; j < col; j++){
                int val = map[j][i];
                if(val == 0)
                    continue;
                if(vals.containsKey(val)){
                    vals.replace(val, (int)vals.get(val)+1);
                }else{
                    vals.put(val, 1);
                }
            }
            List<Entry<Integer, Integer>> entries = new ArrayList<Entry<Integer, Integer>>(vals.entrySet());
            Collections.sort(entries, new Comparator<Entry<Integer, Integer>>() {
                @Override
                public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                    if(o1.getValue() == o2.getValue())
                        return o1.getKey() - o2.getKey();
                    return o1.getValue() - o2.getValue();
                }
            });
            int idx = 0;
            for(Entry<Integer,Integer> entry : entries){
                if(idx >= 100)
                    break;
                map[idx++][i] = entry.getKey();
                if(idx >= 100)
                    break;
                map[idx++][i] = entry.getValue();
            }
            for(int j = idx; j < col; j++){
                map[j][i] = 0;
            }

//            print(col);
//            System.out.println();
        }
    }
    static void r(int row){
        for(int i = 0; i < row; i++){
//            System.out.println("i:" + i);
            Map<Integer, Integer> vals = new HashMap<>();
            for(int j = 0; j < row; j++){
                int val = map[i][j];
                if(val == 0)
                    continue;
                if(vals.containsKey(val)){
                    vals.replace(val, (int)vals.get(val)+1);
                }else{
                    vals.put(val, 1);
                }
            }
            List<Entry<Integer, Integer>> entries = new ArrayList<Entry<Integer, Integer>>(vals.entrySet());
            Collections.sort(entries, new Comparator<Entry<Integer, Integer>>() {
                @Override
                public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                    if(o1.getValue() == o2.getValue())
                        return o1.getKey() - o2.getKey();
                    return o1.getValue() - o2.getValue();
                }
            });
            int idx = 0;
            for(Entry<Integer,Integer> entry : entries){
                if(idx >= 100)
                    break;
                map[i][idx++] = entry.getKey();
                if(idx >= 100)
                    break;
                map[i][idx++] = entry.getValue();
            }

            for(int j = idx; j < row; j++){
                map[i][j] = 0;
            }
//
//            print(row);
//            System.out.println();
        }

        }

    static void print(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
