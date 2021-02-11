package 기출문제.월간코드챌린지;

/**
 * 접근방식을 생각해내지 못하였다
 * 1. 왼쪽이 더 작은경우, 오른쪽이 더 작은경우 => 살아남기가능하다.
 * 2. 양쪽 다 큰 경우 => 살아남기 가능하다.
 * 3. 양쪽 다 작은 경우 => 올바른 값 도출시켜낼 수 없다. 그 이유는 작은값은 단 한번만 터트릴 수 있기때문에 올바르지않은 것.
 */
public class 풍선터트리기1차_Level3 {
    static int[] dp;
    public static void main(String[] args) {
        solution(new int[]{9,-1,-5});

    }
    static int solution(int[] a) {
        int answer = 2;

        int[] leftArr = new int[a.length];
        int[] rightArr = new int[a.length];
        if(a.length == 1){
            return 1;
        }
        int minComp = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++){
            if(minComp > a[i]){
                minComp = a[i];
            }
            leftArr[i] = minComp;
        }
        minComp = Integer.MAX_VALUE;
        for(int i=a.length-1; i >=0; i--){
            if(minComp > a[i]){
                minComp = a[i];
            }
            rightArr[i] = minComp;
        }

        for(int i=1; i<a.length-1; i++){
            // 양쪽다 작으면 살아남을 수 없으므로 continue;
            if(leftArr[i] < a[i] && rightArr[i] < a[i]){
                continue;
            }
            answer++;
        }
        System.out.println(answer);
        return answer;
    }
}
