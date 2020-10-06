import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 여행경로 {
    static ArrayList<String> answer;
    static int[] check;
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        String start = "ICN";
        answer = new ArrayList<>();

        check = new int[tickets.length];
        //Arrays.sort(tickets);

        for(int i=0; i<check.length; i++){
            check[i] = 0;
        }

        /* 2차원 배열 문자열 정렬하기 */
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });


        dfs(0, start, tickets);


        for (String s : answer) {
            System.out.println(s);
        }

    }

    private static boolean dfs(int idx, String start, String[][] tickets) {


        answer.add(start);

        if(idx == tickets.length){
            return true;
        }

        for(int i=0; i<tickets.length; i++){
            if(start.equals(tickets[i][0]) && check[i] == 0){
                check[i] = 1;
                boolean tf = dfs(idx+1, tickets[i][1],tickets);
                if(tf){
                    return true;
                }
                check[i] = 0;
            }

        }
        answer.remove(answer.size()-1);
        return false;
    }

}
