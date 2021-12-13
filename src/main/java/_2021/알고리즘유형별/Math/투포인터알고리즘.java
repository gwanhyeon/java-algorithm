package _2021.알고리즘유형별.Math;



/*
투포인터 알고리즘

1. 시작점(start) 끝점 end이 첫번째 원소의 인덱스 0을 가르키도록한다.
2. 현재 부분합이 M과 같다면 카운트 한다.
3. 현재 부분 합이 M보다 작거나 같다면 end를 1증가한다.
4. 현재 부분 합이 M보다 크다면 start 1을 증가시킨다.
5. 모든 경우를 확인할때까지 2-4번까지의 과정을 반복한다.

 */
public class  투포인터알고리즘 {
    public static void main(String[] args) {
        int n = 5;       // 데이터 개수 N
        int m = 5;       // 합 M

        int[] arr = {1,2,3,2,5};

        int result = 0;
        int summary = 0;
        int end=0;


        for(int start=0; start<n; start++){

            while(summary < m && end < n){
                summary += arr[end];
                end+=1;
            }

            if(summary == m){
                result++;
            }
            summary -= arr[start];
        }
        System.out.println(result);

    }
}
