package _2021.개인문제풀이;

public class 기지국설치 {
    public static void main(String[] args) {
        solution(11, new int[]{4,11},1);






    }
    static int[] check;
    static int solution(int n, int[] stations, int w) {
        int answer = 0;
        check = new int[n+1];
        int idx = 0;
        for(int i=0; i<stations.length; i++){
            check[stations[i]] = 2;
            for(int j=1; j<=w; j++){
                if(stations[i] == 1){
                    check[stations[i]+j] = 1;
                }else if(stations[i] == n){
                    check[stations[i]-j] = 1;
                }else {
                    check[stations[i]+j] = 1;
                    check[stations[i]-j] = 1;
                }
            }
        }
        for(int i=1; i<=n; i++){
            //
            if(check[i] == 0){

            }

        }


        return answer;
    }
}
