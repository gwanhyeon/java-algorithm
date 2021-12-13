// https://yabmoons.tistory.com/575
package _2021.스터디.스터디_GN.스터디_GN_10주차;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
    public static void main(String[] args) {
        solution(10);
    }
    static int[] solution(int n){
        //1. 맵 초기화
        int[][] map = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                map[i][j] = -1;
            }
        }
        List<Integer> answer = new ArrayList<>();

        // 최댓값 선언(등차수열 1,2,3,4) -> 피타고라스 삼각수 공식 (N * (N+1)) / 2
        int maxSize = (n * (n+1)) / 2;

        // 방향 왼쪽대각, 아래, 오른쪽 대각(기본값: 왼쪽 대각)
        int dir = 0;
        int top = 1;
        int bottom = n;
        int left = 1;
        int right = 0;
        int num = 1;

        while(num <= maxSize){
            // 왼쪽 대각 값 채우기
            if(dir == 0){
                for(int i=top; i<=bottom; i++){
                    map[i][left] = num++;
                }
                top++;
                left++;
                dir = 1;
            }
            // 바닥 채우기
            else if(dir == 1){
                for(int i=left; i<=bottom-right; i++){
                    map[bottom][i] = num++;
                }
                bottom--;
                dir = 2;
            }
            // 오른쪽 대각 채우기
            else if(dir == 2){
                for(int i=bottom; i >= top; i--){
                    map[i][i-right] = num++;
                }
                right++;
                top++;
                dir = 0;
            }
        }

        // 달팽이형들 출력
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] != -1){
                    answer.add(map[i][j]);
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
