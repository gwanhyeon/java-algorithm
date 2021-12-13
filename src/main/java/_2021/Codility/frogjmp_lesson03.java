package _2021.Codility;

/**
 * 1. 최대한 Y의 범위까지 몇번을 점프할 수 있는지를 확인하는 문제입니다.
 * 처음에 range를 제대로 보지못하고 while문으로 처리를 하였는데 시간초과가 나왔습니다.
 * 이분탐색으로 풀어야하나라는 생각을 했지만 단순히 생각하면 매우 간단한 문제였습니다.
 * 2. 전체 범위 - 현재 위치를 빼주고 해당 점프의 value만큼을 나누어주면 몇번뛰었는지 개수를 알 수 있습니다.
 * 즉, Y-X -> Y-X / D 의 값으로 나눈값을 처리하였습니다. 나머지가 0이면 해당점프까지만 진행할 수 있고, 나머지가 그것보다 크다면 그것보다 한번더 점프가 가능합니다.
 * 시간복잡도 O(1)
 */
public class frogjmp_lesson03 {
    public static void main(String[] args) {
        solution(10,85,30);
    }
    static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        // 단순히 반복문으로 터지는 로직
        /*
        int jump = X;
        int answer = 0;
        while(jump < Y){
            jump += D;
            answer++;
        }
        System.out.println("answer = " + answer);
        */
        int jumpValue = Y-X;
        int jumpSize = jumpValue / D;
        int answer = (jumpValue % D) == 0? jumpSize : jumpSize+1;
        System.out.println(answer);
        return answer;
    }
}
