import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 순위 {

    static int[] check = new int[101];
    static int[][] map = new int[101][101];

    public static void main(String[] args) {
        int n = 5;
        int[][] result = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        for(int i=0; i<result.length; i++){
            map[result[i][0]][result[i][1]] = 1;
        }
        for(int i=0; i<n; i++){
            bfs(i,n);
        }
        Arrays.sort(check);
        int max = check[check.length-1];
        int min = check[0];
//
//        for(int i=0; i<check.length; i++){
//            max = Math.max(max, check[i]);
//        }
        System.out.println(max);
    }

    static void bfs(int node,int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int dx = q.poll();
            for(int i=node+1; i<=n; i++){
                if(map[dx][i] == 1){
                    check[i] +=1;
                    q.add(i);
                }
            }
        }
    }
}
