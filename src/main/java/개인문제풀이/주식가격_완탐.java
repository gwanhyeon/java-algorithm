public class 주식가격_완탐 {

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] arr = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){


                // 주식가격이 떨어졌을때 break;
                if(prices[i] > prices[j]){
                    arr[i] = j-i;
                    break;
                }
                // 마지막에 도달했다면 떨어지지 않은 것으로 판단
                if(j == prices.length-1){
                    arr[i] = j-i;
                }
            }

        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }
}
