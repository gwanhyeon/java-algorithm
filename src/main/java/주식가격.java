public class 주식가격 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] arr = new int[prices.length];

        for(int i=0; i<prices.length; i++){
//            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                if(prices[i] > prices[j]){
                    arr[i] = j-i;
                    break;
                }
                if(j == prices.length-1){
                    arr[i] = j-i;
                }
//                if(prices[i] <= prices[j]){
//                    cnt++;
//                }
            }

        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }
}
