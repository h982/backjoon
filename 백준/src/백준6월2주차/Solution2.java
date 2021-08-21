import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution2 {
    static final int MAX = 10;
    static class Data implements Comparable<Data> {
        int age, date;
        public Data(int age, int date) {
            this.age=age;
            this.date=date;
        }
        @Override
        public int compareTo(Data o) {
            if (this.date == o.date)
                return o.age-this.age;
            return this.date-o.date;
        }
    }
    static PriorityQueue<Data>ageup = new PriorityQueue<>();
    static PriorityQueue<Data>agedown = new PriorityQueue<>();
    static int pfizer, moderna, janssen;
    static void init() throws IOException{
        int H = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        pfizer = Integer.parseInt(st.nextToken());
        moderna = Integer.parseInt(st.nextToken());
        janssen = Integer.parseInt(st.nextToken());
        ageup.clear();
        agedown.clear();

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < H; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp < 65)
                agedown.add(new Data(temp, 1));
            else if (temp >= 65)
                ageup.add(new Data(temp, 1));
        }
        solve();
    }
    static void solve() {
        /*
         * 일괄 전처리작업 시행
         * 나이가 높은사람부터 접종을 시작한다
         * 이때, 화이자백신의 개수가 연령대 개수에 못미친다면, 모더나개수를 먼저 사용한다.
         *
         * 얀센의경우는 나이가 높은사람들이 다 처리되고 난 후 생각하면 된다 ( 그리디 ? )
         */
        /*
         * 처리할때마다 늘어나는기간 answer
         * 오늘하루 처리할 수 있는 사람의양 today = MAX (일일마다 초기화)
         *
         */
        int nowday = 0;
        PriorityQueue<Integer> moderna2 = new PriorityQueue<>();
        PriorityQueue<Integer> pfizer2 = new PriorityQueue<>();
        boolean noVaccine = false;
        while(!ageup.isEmpty() || !agedown.isEmpty() || !moderna2.isEmpty() || !pfizer2.isEmpty()) {
            int today = MAX;
            if (noVaccine) break;
            while(today != 0) {
                if (!ageup.isEmpty()) {
                    if (ageup.size() > pfizer/2) {
                        if (moderna == 0) {
                            noVaccine = true;
                            break;
                        }
                        ageup.poll();
                        moderna2.add(nowday + 7);
                        moderna--;
                    }
                    else {
                        if (pfizer == 0) {
                            noVaccine = true;
                            break;
                        }
                        ageup.poll();
                        pfizer2.add(nowday + 5);
                        pfizer--;
                    }
                }
                else if(!agedown.isEmpty()) {
                    if (agedown.size() > janssen) {
                        if (moderna == 0) {
                            noVaccine = true;
                            break;
                        }
                        Data out = agedown.poll();
                        moderna2.add(nowday + 7);
                        moderna--;
                    }
                    else {
                        if (janssen == 0) {
                            noVaccine = true;
                            break;
                        }
                        agedown.poll();
                        janssen--;
                    }
                }
                else if(!moderna2.isEmpty() || !pfizer2.isEmpty()){
                    boolean modernaOk = false;
                    boolean pfizerOk = false;
                    if(!moderna2.isEmpty()){
                        if(moderna2.peek() <= nowday){
                            if (moderna == 0) {
                                noVaccine = true;
                                break;
                            }
                            moderna2.poll();
                            moderna--;
                            modernaOk = true;
                        }
                    }
                    if(!modernaOk && !pfizer2.isEmpty()){
                        if(pfizer2.peek() <= nowday) {
                            if (pfizer == 0) {
                                noVaccine = true;
                                break;
                            }
                            pfizer2.poll();
                            pfizer--;
                            pfizerOk = true;
                        }
                    }
                    if(!modernaOk && !pfizerOk)
                        break;
                }
                today--;
            }
            nowday++;
        }

        if (noVaccine)
            output.append("NO VACCINE" +"\n");
        else {
            output.append(nowday +  "\n");
        }
    }
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(output);
    }
}