package 스터디_SNU.Section03;


/**
 * 1. 문제 풀이 시간: 초과
 *
 * 2. 문제 풀이 방식:
 * - 기지국이 설치되지 않은 위치일 경우 현재 위치에서 (가중치 * 2) + 1을 통해서 (왼쪽 전파 범위, 오른쪽 전파 범위, 기지국 범위)를 더해 갱신해줍니다.
 * 즉, 가중치값에 따른 전파범위를 구해서 다음 탐색 위치를 갱신해줍니다. 단 현재 위치값은 기지국이 설치된 아파트보다 크거나 같아야합니다.
 *
 * - 기지국이 설치된 경우
 * 현재 위치가 기지국이 설치되거나 큰 범위일 경우 (현재 위치 + 전파범위) + 1을 통하여 기지국이 설치된 전파범위를 벗어난 위치로 갱신시켜준다.
 *
 * 3. 시간복잡도
 * O(N)이하 1-N 아파트의 범위만큼을 진행하되 location을 갱신하면서 진행하기때문에 O(N)이하값으로 진행 가능.
 */

//https://zzang9ha.tistory.com/73
public class programmers_기지국설치_kgh {
    static int[] check;
    public static void main(String[] args) {
        System.out.println(solution(11,new int[]{4,11}, 1));
    }
    static int solution(int n, int[] stations, int w) {
        int answer = 0;

        int idx = 0;
        int location = 1;

        while(location <= n){
            // 기지국 설치된 경우
            // comment 현재 포인트 idx값이 범위 && 전파범위 체크(즉, 설치된 기지국의 범위)를 구하여 (설치된 동 idx + w + 1)
            if(idx < stations.length && location >= stations[idx] - w){
                location = stations[idx] + w + 1;
                idx++;
            }
            // programmers_기지국설치_kgh 되지 않은 경 범위(포인트값이 아직 넘어가지 않았을 경우)
            else {
                location += (w*2) + 1; // 왼쪽 전파범위 + 기지국 + 오른쪽 전파범
                answer++;          // 기지국 설치
            }
        }

        return answer;
    }
    /* 잘못된 코드
    static int solution(int n, int[] stations, int w) {
        int answer = 0;
        check = new int[n+1];

        // 기지국 체크
        for(int i=0; i< stations.length; i++){
            check[stations[i]] = 1;
        }

        // 기지국에서 전파 범위 체크
        for(int i=1; i<=w; i++){
            for(int j=0; j<stations.length; j++){
                // 좌측 아파트
                if(stations[j]-i >= 1){
                    check[stations[i]-j]=1;
                }
                // 우측 아파트
                if(stations[j]+i <= n){
                    check[stations[j]+i]=1;
                }
            }
        }

        for(int i=0; i<check.length; i++){
            int cnt = 0;

            while(check[i] == 0){
                cnt++;
                i++;
                if(i == n){
                    break;
                }
            }

            if(cnt != 0){
                int spread = (w*2)+1;
                double sum = 유형별.Math.ceil((double) cnt / spread);
                answer += (int)sum;
            }
        }


        return answer;
    }

     */
}
