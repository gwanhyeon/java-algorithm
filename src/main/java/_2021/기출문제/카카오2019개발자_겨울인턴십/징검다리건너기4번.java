package _2021.기출문제.카카오2019개발자_겨울인턴십;
class 징검다리건너기4번{
    public static void main(String[] args) {
        int res= solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
        System.out.println(res);
    }
    static int solution(int[] stones, int k) {

        int left = 0;
        int right = Integer.MAX_VALUE;
        int mid = 0;
        int count = 0;
        boolean flag = false;
        int answer = 0;

        while(left <= right){
            int[] stone_copy = stones.clone();
            mid = (left + right) / 2;
            count = 0;
            flag = false;

            for(int i=0; i<stone_copy.length; i++){
                if(stone_copy[i] <= mid){
                    stone_copy[i] = 0;
                    count++;
                    // count 값이 k와 같으면 건너지못하므로 사람의 순서를 더 적게해서 수행한다.
                    if(count == k){
                        flag = true;
                        break;
                    }
                }else {
                    count = 0;
                }
            }
            if(flag){
                right = mid-1;
                answer = mid;
            }else {
                left = mid+1;
            }
        }
        return answer;
    }
}