package _2021.스터디.스터디_SNU.Section06;


import java.util.ArrayList;
import java.util.List;

public class 투포인트알고리즘 {
    public static void main(String[] args) {
        //twoPoint();
        prefix();
    }

    /**
     * prefix sum을 활용한 알고리즘
     * 1. Prefix Sum을 계산하여 배열 P에 저장한다.
     * 2. 매 M개 쿼리 정보를 확인할 때, 구간 합은 P[R] - P[L-1]
     * 예시)
     *      10 20 30 40  50
     *   0  10 30 60 100 150
     *
     *   첫번째 원소부터 3번째 원소까지의 구간합(10+20+30)일 경우
     *   60-0을뺀 것이 구간합이된다.
     *   시간복잡도는 O(M+N)
     */
    private static void prefix() {
        int n = 5;
        int[] data = {10,20,30,40,50};
        int sum = 0;
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            sum += data[i];
            arr.add(sum);
        }
        int left =  3;
        int right = 4;
        System.out.println(arr.get(right-1) - arr.get(left-2));     // 인덱스가 0인경우
        System.out.println(arr.get(right) - arr.get(left-1));     // 인덱스가 1인경우 범위 파악잘하

    }

    /**
     * 1. 시작점과 끝점이 첫번째 원소의 인덱스 0 을 가리키도록한다.
     * 2. 현재 부분 합이 m과 같다면 카운트한다.
     * 3. 현재 부분합이 m보다 작거나 같다면 end를 1증가시킨다.(합을 증가시키는 과정)
     * 4. 현재 부분합이 m보다 크다면 start를 증가시킨다.(합을 줄이는 과정)
     * 5. 모든 경우를 확인할 때 까지 2번부터 4번의 과정을 반복한다.
     */
    private static void twoPoint() {
        int n = 5;      // 데이터 개수
        int m = 5;      // 찾고자 하는 합
        int[] data = {1,2,3,2,5};
        // 1 = 1 end++
        // 1 2 = 3 end++
        // 1 2 3 = 6 start++
        // 2 3 = start++
        // 3 = end++
        // 3 2
        int answer = 0;
        int sum = 0;
        int end = 0;

        int start = 0;
        while(start<data.length){
            while(sum < m && end < n){
                sum += data[end];
                end++;
            }
            //값을 찾았을때
            if(sum == m){
                answer++;
            }
            sum -= data[start++];
        }
        System.out.println(answer);
    }
}
