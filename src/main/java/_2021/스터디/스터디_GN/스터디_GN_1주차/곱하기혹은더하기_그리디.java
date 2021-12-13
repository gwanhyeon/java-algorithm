package _2021.스터디.스터디_GN.스터디_GN_1주차;

// comment 복습 201227,

/**
 * 풀이시간: 10분
 * 두개의 재귀함수를 이용하여 * 경우와 , + 경우를 통해 더해주면서 진행한다. 선택된 개수가 arr.length의 길이와 같다면 종료시키고 다음 연산을 진행한다.
 *
 * 두수에 대하여 연산을 수행할때 1이하인 경우에는 더하고 두수가 모두 2이상인경우에는 곱하면 알 수 있다.
 * 예를 들어 5,6 의 값이 들어오게 된다면 5 * 6 = 30, 5 + 6 = 11
 * 예: 0 * 2 * 9 * 8 * 4 -> 0 * 2 * 9 * 8 + 4
 */
public class 곱하기혹은더하기_그리디 {
    static int max = 0;
    public static void main(String[] args) {
        solution(new int[]{0,2,3,8,4});
        System.out.println();
        max = 0;
        //solution(new int[]{5,7,6});
        //solution1(new int[]{0,2,3});

    }
    private static void solution1(int[] arr) {

        int answer = arr[0];
        for(int i=1; i<arr.length; i++){
            int num = arr[i];
            // 0,1 이하인 값이 올 경우에는 더하고 그게 아닐 경우에는 곱하기를 진행해준다.
            if(num <= 1 || answer <= 1){
                answer += num;
            }else {
                answer *= num;
            }
        }
        System.out.println(answer);
    }

    private static void solution(int[] arr) {

        dfs(arr,1,arr[0]);
        System.out.println(max);
    }

    private static void dfs(int[] arr, int cnt, int sum) {

        if(cnt == arr.length){
            if(max < sum){
                max = sum;
            }
            //System.out.println(sum);
            return;
        }
        //System.out.println("dfs(arr,"+ (cnt+1) +","+ "("+ sum +"*"+ arr[cnt]+")");
        dfs(arr, cnt+1, sum * arr[cnt]);

        //System.out.println("dfs(arr,"+ (cnt+1) +","+ "("+ sum +"+"+ arr[cnt]+")");
        dfs(arr, cnt+1, sum + arr[cnt]);
        //System.out.println("dfs(" + (cnt+1) + "," + (arr[cnt]) + ")");
    }
}
