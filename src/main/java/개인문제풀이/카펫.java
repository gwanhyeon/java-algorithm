public class 카펫 {
    public static void main(String[] args) {
        int[] answer = new int[2];

        int brown = 10;
        int yellow = 2;

        for(int i=yellow; i >= (yellow/i); i--){
            // 나눠지는값이 아니면분리 못
            if(yellow % i != 0){
                continue;
            }
            // 가로 2배, 세로2배 모서리 4개 추가
            if(((2*i)+(2*(yellow/i)) + 4) == brown){
                answer[0] = 2+i;        // 가로 + 2 끝점
                answer[1] = (2+(yellow/i)); // 세로 +2 끝점
                break;
            }
        }
        System.out.println(answer[0] + ""+ answer[1]);
    }
}
