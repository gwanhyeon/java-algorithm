package 카카오2019개발자_겨울인턴십;

import java.util.Stack;

public class 크레인인형뽑기1번 {

    static int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
    static int[] moves = {1,5,3,5,1,2,1,4};

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int answer = 0;
        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][moves[i]-1] != 0){
                    if(!s.empty() && s.peek() == board[j][moves[i]-1]){
                            answer += 2;
                            s.pop();
                            board[j][moves[i]-1] = 0;
                    }else {
                        s.push(board[j][moves[i]-1]);
                        board[j][moves[i]-1] = 0;
                    }
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
