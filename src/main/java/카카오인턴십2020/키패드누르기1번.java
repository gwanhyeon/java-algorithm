package 카카오인턴십2020;

public class 키패드누르기1번 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }
    static String solution(int[] numbers, String hand) {
        String answer = "";

        int left_hand = -1;
        int right_hand = -1;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<numbers.length; i++){
            int push = numbers[i];
            int left_dist = -1;
            int right_dist = -1;
            // 1,4,7일 경우 L버튼 누르고 현재 위치 갱신
            if(push == 1 || push == 4 || push == 7){
                left_hand = push;
                sb.append("L");
                continue;
            }
            // 3,6,9일 경우 R버튼 누르고 현재 위치 갱신
            else if(push == 3 || push == 6 || push == 9){
                right_hand = push;
                sb.append("R");
                continue;
            }
            // 2가 눌러야 할 숫자일 경우
            if(push == 2){
                // *, # 에 머물러 있는 경우 거리 계산
                if(left_hand == -1){
                    left_dist = 4;
                }
                if(right_hand == -1) {
                    right_dist = 4;
                }

                // 왼쪽이나 오른쪽에 위치한 경우
                if(left_hand == 1 || left_hand == 3) left_dist = 1;
                if(right_hand == 1 || right_hand == 3) right_dist = 1;
                if(left_hand == 4 || left_hand == 6) left_dist = 2;
                if(right_hand == 4 || right_hand == 6) right_dist = 2;
                if(left_hand ==7 || left_hand == 9) left_dist = 3;
                if(right_hand == 7 || right_hand == 9) right_dist = 3;

                // 현재 위치한 손이 가운데 위치할 경우
                if(left_hand == 2) left_dist = 0;
                if(right_hand == 2) right_dist = 0;
                if(left_hand == 5) left_dist = 1;
                if(right_hand == 5) right_dist = 1;
                if(left_hand == 8) left_dist = 2;
                if(right_hand == 8) right_dist = 2;
                if(left_hand == 0) left_dist = 3;
                if(right_hand == 0) right_dist = 3;
            }
            // 5가 눌러야 할 숫자일 경우
            else if(push == 5){

                // *, # 에 머물러 있는 경우 거리 계산
                if(left_hand == -1) left_dist = 3;
                if(right_hand == -1) right_dist = 3;

                // 왼쪽이나 오른쪽에 위치한 경우
                if(left_hand == 1 || left_hand == 3) left_dist = 2;
                if(right_hand == 1 || right_hand == 3) right_dist = 2;
                if(left_hand == 4 || left_hand == 6) left_dist = 1;
                if(right_hand == 4 || right_hand == 6) right_dist = 1;
                if(left_hand ==7 || left_hand == 9) left_dist = 2;
                if(right_hand == 7 || right_hand == 9) right_dist = 2;

                // 현재 위치한 손이 가운데 위치할 경우
                if(left_hand == 2) left_dist = 1;
                if(right_hand == 2) right_dist = 1;
                if(left_hand == 5) left_dist = 0;
                if(right_hand == 5) right_dist = 0;
                if(left_hand == 8) left_dist = 1;
                if(right_hand == 8) right_dist = 1;
                if(left_hand == 0) left_dist = 2;
                if(right_hand == 0) right_dist = 2;
            }
            // 8이 눌러야 할 숫자일 경우
            else if(push == 8){
                // *, # 에 머물러 있는 경우
                if(left_hand == -1) left_dist = 2;
                if(right_hand == -1) right_dist = 2;

                // 왼쪽이나 오른쪽에 위치한 경우
                if(left_hand == 1 || left_hand == 3) left_dist = 3;
                if(right_hand == 1 || right_hand == 3) right_dist = 3;
                if(left_hand == 4 || left_hand == 6) left_dist = 2;
                if(right_hand == 4 || right_hand == 6) right_dist = 2;
                if(left_hand ==7 || left_hand == 9) left_dist = 1;
                if(right_hand == 7 || right_hand == 9) right_dist = 1;

                // 가운데 위치 할 경우
                if(left_hand == 2) left_dist = 2;
                if(right_hand == 2) right_dist = 2;
                if(left_hand == 5) left_dist = 1;
                if(right_hand == 5) right_dist = 1;
                if(left_hand == 8) left_dist = 0;
                if(right_hand == 8) right_dist = 0;
                if(left_hand == 0) left_dist = 1;
                if(right_hand == 0) right_dist = 1;
            }else if(push == 0){

                // *, # 에 머물러 있는 경우
                if(left_hand == -1){
                    left_dist = 1;
                }
                if(right_hand == -1){
                    right_dist = 1;
                }

                if(left_hand == 1 || left_hand == 3) left_dist = 4;
                if(right_hand == 1 || right_hand == 3) right_dist = 4;
                if(left_hand == 4 || left_hand == 6) left_dist = 3;
                if(right_hand == 4 || right_hand == 6) right_dist = 3;
                if(left_hand ==7 || left_hand == 9) left_dist = 2;
                if(right_hand == 7 || right_hand == 9) right_dist = 2;
                // 가운데 위치 할 경우
                if(left_hand == 2) left_dist = 3;
                if(right_hand == 2) right_dist = 3;
                if(left_hand == 5) left_dist = 2;
                if(right_hand == 5) right_dist = 2;
                if(left_hand == 8) left_dist = 1;
                if(right_hand == 8) right_dist = 1;
                if(left_hand == 0) left_dist = 0;
                if(right_hand == 0) right_dist = 0;
            }

            if(right_dist > left_dist){
                left_hand = push;
                sb.append("L");
            }else if(right_dist < left_dist){
                right_hand = push;
                sb.append("R");
            }else {
                if(hand.equals("right")){
                    right_hand = push;
                    sb.append("R");
                }else {
                    left_hand = push;
                    sb.append("L");
                }
            }
        }
        //System.out.print(sb.toString());
        answer = sb.toString();
        return answer;
    }
}
