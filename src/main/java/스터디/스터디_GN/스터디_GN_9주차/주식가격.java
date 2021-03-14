package 스터디.스터디_GN.스터디_GN_9주차;

public class 주식가격 {
    public static void main(String[] args) {
        solution(new int[]{1,2,3,2,3});
    }
    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                cnt++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
