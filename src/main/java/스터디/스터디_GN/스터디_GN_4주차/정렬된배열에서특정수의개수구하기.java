package 스터디.스터디_GN.스터디_GN_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 1. 문제 풀이 시간: 20분
 * 2. 컴퓨팅사고
 * 이분탐색 문제로 정렬된 상태이므로 target값의 시작점과 끝점의 인덱스를 구해서 끝점-시작점을 계산하면 결국 최종 타겟의 개수를 구할 수 있습니다.
 * 3. 시간복잡도 O(logN)
 */
public class 정렬된배열에서특정수의개수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while(st.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        Arrays.sort(arr);
        int end = getEndIdx(target, arr);
        int start = getStartIdx(target,  arr);
        answer = end - start;
        System.out.println(answer);
    }

    /**
     * 시작점을 찾는 함수
     * arr[mid] >= target의 범위를 잡고 들어가면 최종적으로 target의 첫번째 인덱스 값을 가질 수 있습니다.
     * @param target
     * @param arr
     * @return
     */
    private static int getStartIdx(int target, int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = (start + end) / 2;
            // end의 값을 좁히면서 첫번째 인덱스 검색
            if(arr[mid] >= target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return end;
    }

    /**
     * 끝점을 찾는 함수
     * arr[mid] > target의 범위를 잡고 들어가면 최종적으로 target의 마지막 인덱스 값을 가질 수 있습니다.
     * @param target
     * @param arr
     * @return
     */
    private static int getEndIdx(int target, int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = (start + end) / 2;
            // 1 1 2 2 2 2 3  target = 2
            if(arr[mid] > target){
                end = mid-1;
            }
            // start의 값을 올리면서 마지막 인덱스값 검색
            else {
                start = mid+1;
            }
        }
        return end;
    }
}


/* 기본 이진탐색
static int BinarySearch(int target, int len) {

        int start = 0;
        int end = len-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] < target){
                start = mid+1;
            }else if(arr[mid] > target){
                end = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
 */