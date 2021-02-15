package 프로그래머스.Level2;

import java.util.Arrays;

public class 주식가격 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 2, 3});
//        solution(new int[]{1,1,1,1,1});
    }
    static int[] solution(int[] prices) {
        Arrays.sort(prices);
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            int len = prices.length-1-i;
            int curr = prices[i];
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                if(curr <= prices[j]){
                    cnt++;
                }
            }
            if(cnt == len){
                answer[i] = len;
            }else {
                answer[i] = len-cnt-1;
            }
        }
        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }
}
