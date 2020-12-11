package 스터디.스터디_GN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 1. 풀이시간: 32분
** 2. 접근방식(내림차순정렬로 해당 배열값을 재정렬 시킨다. 그리고 가장 큰값이 K번이 넘어가면 종료시키고 그게 아니라면 sum에 값을 더해나간다.
** 몇개의 값을 count해서 나갔는지 체크한다. 그리고나서 가장큰값의 다음으로 큰값을 한번 더해주고 While문을 진행한다.
*  결국 가장 큰값 + 가장큰값의 다음값을 바탕으로 최댓값을 구할 수 있는 문제이기때문에 그리디 알고리즘이라고 할 수 있다.
*  카운트한값이 m(몇개를 더하는값)과 같다면 해당 루프를 빠져나와 종료 후 Sum을 출력한다.
 */
public class 큰수의법칙_그리디 {
    public static void main(String[] args) throws IOException {
       solution(5,8,3,new int[]{2,4,5,4,6});
       solution(5,7,2,new int[]{3,4,3,4,3});

       solution1(5,8,3,new int[]{2,4,5,4,6});
       solution1(5,7,2,new int[]{3,4,3,4,3});
    }
    // comment 수열의 수학적 공식을 사용한 풀이
    private static void solution1(int n, int m, int k, int[] map) {
        //comment m / (k+1) -> 수열이 반복되는 횟수, 가장 큰 수가 등장하는 횟수
        ArrayList<Integer> arr = new ArrayList<>(0);
        for (int i : map) {
            arr.add(i);
        }
        Collections.sort(arr, Collections.reverseOrder());
        int count = (m / (k+1)) * k;
        //comment 나누어 떨어지지않는 경우도 고려
        count += m % (k+1);

        int res = 0;
        res += (count) * arr.get(0);
        res += (m - count) * arr.get(1);
        System.out.println(res);


    }
    static void solution(int n,int m,int k, int[] map){

        ArrayList<Integer> arr = new ArrayList<>(0);
        for (int i : map) {
            arr.add(i);
        }
        Collections.sort(arr, Collections.reverseOrder());
        int start = arr.get(0);
        int second = arr.get(1);
        int sum = 0;
        int sum_cnt = 0;
        while(true){
            int cnt = 0;
            if(sum_cnt == m){
                break;
            }
            while(cnt < k){
                sum += start;
                cnt++;
                sum_cnt++;
            }
            sum += second;
            sum_cnt++;
        }
        System.out.println(sum);
    }
}
