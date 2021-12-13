package _2021.스터디.스터디_GN.스터디_GN_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2110
 */
public class 공유기설치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] house = new int[n];
        for(int i=0; i<n; i++){
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);          // 12849 -> 12489

        System.out.println(binarySearch(house,m));
    }

    private static int binarySearch(int[] house, int wifi) {
        int answer = 0;
        int start = 1;                                      // 시작 인덱스는 1번부터
        int end = house[house.length-1] - house[0];         // 가능한 최대 거리

        while(start <= end){
            int mid = (start+end) / 2;
            // 와이파이 구역보다 크다면
            if(findRange(house, mid, wifi)){
                answer = Math.max(answer, mid);
                start = mid+1;
            }
            // 와이파이 구역보다 작다면
            else {
                end = mid-1;
            }
        }
        return answer;
    }

    private static boolean findRange(int[] house, int mid, int wifi) {
        // 최소거리는 1
        int cnt = 1;
        // 첫번째값과 거리
        int end = house[0]+mid;

        // 모든 집을 탐색한다.
        for(int i=0; i<house.length; i++){
            // 탐색하는값이 최대거리이상일 경우
            if(house[i] >= end){
                cnt++;
                end = house[i] + mid;
            }
        }
        return cnt >= wifi ? true : false;
    }
}
