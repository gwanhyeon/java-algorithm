package _2021.프로그래머스.Level1;

public class 콜라츠추측 {
    public static void main(String[] args) {
        solution(6);
        //solution(626331);
    }
    static int solution(int num) {
        int answer = 0;

        int idx = 0;
        while(num > 1){
            if(idx >= 500){
                break;
            }
            if(num % 2 == 0){
                num = num/2;
            }else {
                num = (num * 3) + 1;
            }
            idx++;
        }
        if(num != 1){
            answer = -1;
            return answer;
        }
        answer = idx;
        System.out.println(answer);
        return answer;
    }
}
