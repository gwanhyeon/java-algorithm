package _2021.스터디.스터디_SNU.Section15;

public class programmers_타겟넘버_kgh {
    static int answer = 0;
    public static void main(String[] args) {
        solution(new int[]{1,1,1,1,1}, 3);
    }
    static int solution(int[] numbers, int target) {
        dfs(0,0, numbers, target);
        System.out.println(answer);
        return answer;
    }

    private static void dfs(int cnt,int sum, int[] numbers, int target) {
        if(cnt == numbers.length){
            if(sum == target) answer++;
            return;
        }
        dfs(cnt+1, sum+numbers[cnt], numbers, target);
        dfs(cnt+1, sum-numbers[cnt], numbers, target);
    }
}
