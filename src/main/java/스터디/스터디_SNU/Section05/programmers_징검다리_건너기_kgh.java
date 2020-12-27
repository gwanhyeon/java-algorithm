package 스터디.스터디_SNU.Section05;

public class programmers_징검다리_건너기_kgh {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,4,5,3,2,1,4,2,5,1}, 3));
    }

    /*
    범위가 1~200,000,000 이기 때문에 초기값을 설정하고
    mid = (시작+끝)/2 가 돌다리를 건널 수 있는 인원이다.
    돌다리 개수(=k) 개가 0이 되는 연속된 개수를 파악한다.
    0이 연속된 개수가 k개를 넘게 되면 돌다리를 건널 수 없는 범위가 되기 때문에 끝을 mid-1로 변경하고 반대로 돌다리를 건널 수 있다면 mid+1 로 변경해서 최종적으로는
     시작이 끝보다 커지면 최대의 인원이 돌다리를 건널 수 있게 되는 경우이다.
     */
    private static int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 10;
        int mid = 0;

        while(start <= end){
            int cnt = 0;
            mid = (start + end) / 2;         // 돌다리 건너는 인원

            for(int i=0; i<stones.length; i++){
                // 돌 적힌수 - 돌다리 건너는 인원(인원수 만큼 감소되기 때문에)이 0보다 작거나 같은경우에 cnt값 증가
                if(stones[i] - mid <= 0){
                    cnt++;
                }
                // 돌 적힌수 - 돌다리 건너는 인원일 경우 최대인원이 될 수 없기 때문에 0으로 초기화
                else {
                    cnt = 0;
                }
                // 돌다리 개수가 k개를 넘게되면 건널수 없는 범위
                if(cnt >= k){
                    end = mid-1;
                    break;
                }
            }
            // 돌다리 건너기 가능이면 mid값보다 1큰 값부터 다시 재탐색을 수행한다.
            if(cnt < k ){
                start = mid+1;
            }
        }
        answer = start;
        return answer;
    }
}


// https://thewayitwas.tistory.com/218
// https://neojjc.tistory.com/5 갑자기 클래스 파일 런 안되는 오류 발생시 -> java-algorithm root source로 지정 및 file Invalide cashe / restart
