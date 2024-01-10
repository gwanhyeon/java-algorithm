package _2024.programmers_01;

public class 약수의개수와덧셈 {
    public static void main(String[] args) {

        int answer = 0;
        int left = 13;
        int right = 17;

        for(int i=left; i<=right; i++){
            int cnt = 0;
            for(int j=1; j<=i; j++){
                if(i % j == 0){
                    cnt += j;
                }
            }
            if(cnt % 2 == 0){
                answer += i;
            }else {
                answer -= i;
            }
        }

    }

}
