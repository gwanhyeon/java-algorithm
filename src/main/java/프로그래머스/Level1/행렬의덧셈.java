package 프로그래머스.Level1;

public class 행렬의덧셈 {
    public static void main(String[] args) {
//        solution(new int[][]{{1,2},{2,3}}, new int[][]{{3,4},{5,6}});
        solution(new int[][]{{1},{2}}, new int[][]{{3},{4}});
    }
    static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[0].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        for (int i = 0; i<answer.length; i++) {
            for(int j=0; j<answer[i].length; j++){
                System.out.print(answer[i][j]);
            }
        }

        return answer;
    }
}
