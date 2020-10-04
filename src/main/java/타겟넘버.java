public class 타겟넘버 {


    static int answer = 0;
    static void dfs(int idx,int target, int sum, int[] numbers){


        System.out.println(sum);

        if(idx == numbers.length){
            if(target == sum){
                answer++;
            }
            return;
        }


        dfs(idx+1, target, sum + numbers[idx], numbers);
        dfs(idx+1, target, sum - numbers[idx], numbers);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        dfs(0,target, 0, numbers);

        System.out.println(answer);
    }
}
