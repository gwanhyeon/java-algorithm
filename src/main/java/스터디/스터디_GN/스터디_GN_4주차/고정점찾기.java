package 스터디.스터디_GN.스터디_GN_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제풀이시간: 30분
 * 2. 컴퓨팅사고
 * 음수일 경우 0미만 인덱스에 접근할 수 없고, 타겟값을 하나씩 넣으면서 고정점인지를 확인합니다.
 * 현재 인덱스와 배열의 인덱스값이 같은 경우 고정점이라고 하기때문에 이분탐색을 통해 해당하는 타겟값을 찾은 경우 해당 target값을 리턴해줍니다.
 * 만약, 타겟을 찾았지만 고정점이 아닌 경우 -1로 리턴을 진행합니다.
 *
 * 3. 시간복잡도
 * O(logN)
 *
 *
 * 5
 * -15 -6 1 3 7
 */

public class 고정점찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while(st.hasMoreTokens()){
            arr[idx++]=Integer.parseInt(st.nextToken());
        }
        int answer = -1;

        // -15 -6 1 3 7
        // -15, [-15] 0 - Max
        for(int i=0; i<arr.length; i++){
            // 음수일 경우 0미만(음수) 인덱스에 접근할 수 없으므로 조건 체크
            if(arr[i] >= 0){
                int target = binarySearch(arr,i);
                if (answer < target) {
                    answer = target;
                }
            }
        }
        System.out.println(answer);
    }
    /**
     * 이분탐색 고정점 찾기 함수
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] < target){
                start = mid+1;
            }else if(arr[mid] > target){
                end = mid-1;
            }
            // -15 -6 1 3 7
            // 원하는 타겟값을 찾은 경우
            else if(arr[mid] == target){
                // 타겟값을 찾앗지만 고정점과 같지 않으면 -1
                if(mid != target){
                    return -1;
                }
                // 고정점과 같으면 target값 리턴
                return target;
            }
        }
        return -1;
    }
}
