package _2021.프로그래머스.Level1;

public class 내적 {
    public static void main(String[] args) {
        solution(new int[]{1,2,3,4}, new int[]{-3,-1,0,2});
    }
    static int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i=0; i<a.length; i++){
            answer += (a[i] * b[i]);
        }

        System.out.println(answer);
        return answer;
    }
}
