package _2024.programmers_01;

public class 콜라츠추측 {
    public static void main(String[] args) {
        int n = 626331;
        int answer = 0;
        while(n > 1){
            if(n%2 == 0){
                n = n /2;
            }else{
                n = (n * 3)+1;
            }
            answer++;
        }
        if(answer != 1){
            answer = -1;
        }

        System.out.println(answer);
    }
}
