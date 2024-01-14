package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Meet> arrList = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            arrList.add(new Meet(startTime, endTime));
        }
        Collections.sort(arrList);
        arrList.forEach(i -> System.out.println(i.startTime + " " + i.endTime));

        // 회의실 배정 개수
        int cnt = 0;
        // 끝의 값을 갱신
        int prevEndTime = 0;
        for(int i=0; i<n; i++){

            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            int currStartTime = arrList.get(i).getStartTime();
            int currEndTime = arrList.get(i).getEndTime();
            System.out.println(currStartTime + " " + currEndTime);
            if(prevEndTime <= currStartTime){
                prevEndTime = currEndTime;
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    /**
     * 정렬 잊어 먹기 말기*
     *
     * this, Object 로 들어온 값 비교 할때
     * this-Object 일 경우 작은순에서 ~ 큰순 오름차순
     * Object-this 일 경우 큰순 ~ 작은순 내림차순*
     */
    private static class Meet implements Comparable<Meet> {
        int startTime;
        int endTime;
        public Meet(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public int compareTo(Meet meet) {
            // 종료시간이 같을 경우
            if(this.endTime == meet.endTime){
                // 시작시간 오름차순 즉, 시작시간중 가장 짧은 시간
                return this.startTime - meet.startTime;
            }else {
                // 종료시간 오름차순 즉, 종료시간중 가장 짧은시간
                return this.endTime - meet.endTime;
            }
        }
    }
}

/**
 * 하나의 회의실
 * 회의 1 시작, 끝 겹치지않게 회의의 최대개수
 * *
 */
