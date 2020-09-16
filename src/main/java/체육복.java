public class 체육복 {
    public static void main(String[] args) {

        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};

        int answer = 0;

        int rent = 0;

        int curr = n - lost.length;

        for(int i=0; i<reserve.length; i++){

            if(i > lost.length-1){
                break;
            }
            // 빌려주기 가능
            if(reserve[i] == lost[i]-1 || reserve[i] == lost[i]+1 ){
                rent +=1;
            }
        }

        answer = curr + rent;
        System.out.println(answer);
    }
}
