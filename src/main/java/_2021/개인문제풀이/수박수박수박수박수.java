package _2021.개인문제풀이;

public class 수박수박수박수박수 {
    public static void main(String[] args) {
        int n = 4;

        String answer = "";

        for(int i=1; i<=n; i++){
            if(i % 2 == 0){
                answer += "박";
            }else {
                answer += "수";
            }
        }
        System.out.println(answer);
    }
}
