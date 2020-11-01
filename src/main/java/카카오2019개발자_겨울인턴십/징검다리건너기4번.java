package 카카오2019개발자_겨울인턴십;

class 징검다리건너기4번{
    static int dp[];
    static int answer = 1;

    public static void main(String[] args) {
        int res= solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
        System.out.println(res);
    }
    static int solution(int[] stones, int k) {
        dp = new int[stones.length+1];

        for(int i=0; i<k; i++){
            dp[i] = stones[i];
        }

        while(true){
            int cnt = 0;
            int idx = k;
            for(int i=k; i<=stones.length; i++){
                if(dp[i] == 0){
                    cnt++;
                    continue;
                }

                dp[i] = dp[idx-i]-1;
                idx--;
            }
            answer++;
            if(cnt >= k){
                break;
            }
        }
        return answer;
    }
}