import java.util.*;

public class hi {
    public static void main(String[] args) {
        int[] ans = solution(new long[]{8, 13, 5, 8}, new int[][]{{1,3,10}, {3,4,1}, {4,2,2,}, {2,1,3}});
        System.out.println(Arrays.toString(ans));
    }

    static HashSet[] input;
    static List[] output;
    static public int[] solution(long[] ages, int[][] wires){
        input = new HashSet[ages.length];
        output = new ArrayList[ages.length];

        PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                int ret = Long.compare(o1.age, o2.age);
                if(ret == 0){
                    return o1.idx - o2.idx;
                }
                return ret;
            }
        });

        for(int i = 0; i < ages.length; i++){
            input[i] = new HashSet<Integer>();
            output[i] = new ArrayList<int[]>();
            pq.add(new Data(ages[i], i));
        }

        for(int i = 0; i < wires.length; i++){
            int[] temp = wires[i];
            input[temp[1]-1].add(temp[0]-1);
            output[temp[0]-1].add(new int[]{temp[1]-1, temp[2]});
        }
        int count = 0;
        int[] answer = new int[ages.length];
        boolean[] isUsed = new boolean[ages.length];
        while(!pq.isEmpty() && count < ages.length){
            Data data = pq.poll();
            if(isUsed[data.idx]){
                continue;
            }
            isUsed[data.idx] = true;
            answer[count++] = data.idx + 1;
            List<int[]> out = output[data.idx];
            for(int i = 0; i < out.size(); i++){
                int[] temp = out.get(i);
                if(isUsed[temp[0]]){
                    continue;
                }
                HashSet<Integer> in = input[temp[0]];
                in.remove(data.idx);
                if(in.isEmpty()){
                    pq.add(new Data(data.age + temp[1], temp[0]));
                }
            }
        }
        return answer;
    }
    static class Data{
        long age;
        int idx;
        public Data(long age, int idx){
            this.age = age;
            this.idx = idx;
        }
    }


    static int sol(int money, int minratio, int maxratio, int ranksize, int threshold, int months){

        for(int i = 0; i < months; i++){
            int calMoney = (money/100) * 100;
            float temp = calMoney - threshold;
            if(temp < 0){
                break;
            }
            int ratio = minratio;
            temp = (temp + 1) / ranksize;
            if(temp - (int)temp > 0){
                ratio += (int)temp;
            }else{
                ratio += (int)temp+1;
            }
            if(ratio > maxratio){
                ratio = maxratio;
            }
            money -= calMoney / 100 * ratio;


        }

        return money;
    }
}
