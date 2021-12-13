import java.util.Collections;

public class 타겟넘버_dfs {
    static int answer = 0;
    static void dfs(int idx,int target, int sum, int[] numbers){
        if(idx == numbers.length){
            if(target == sum){
                answer++;
            }
            return;
        }

        dfs(idx+1, target, sum + numbers[idx], numbers);
        System.out.println("idx+1:"+(idx+1)+" sum+numbers[idx]:"+sum+numbers[idx]);
        dfs(idx+1, target, sum - numbers[idx], numbers);
    }

    public static void main(String[] args) {
//        int[] numbers = {1, 1, 1, 1, 1};
//        int target = 3;

        int[] numbers = {1, 2, 3, 4, 6};
        int target = 15;

        int res = 0;
        for (int number : numbers) {
            res+=number;
        }

        dfs(0,res, 0, numbers);

        System.out.println(answer);
    }
}
