package _2021.스터디.단체;

/**
 * 1. 풀이시간:10분
 * 2. 컴퓨팅사고
 * binarySearch 함수를 구현하여 해당되는 타겟값이 있으면 해당 인덱스를 반환하고 그렇지 않으면 -1을 반환합니다.
 * insertBinarySearch 함수를 구현하여 현재 해당되는 Target의 끝지점 인덱스를 찾아 반환합니다.
 * end는 target값의 이전인덱스이기 때문에 end+1을 반환시켜줍니다.
 *
 * 3. 시간복잡도 O(logN)
 */
public class leetcode_search_insert_position {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));

    }
    static int searchInsert(int[] nums, int target) {

        int answer = binarySearch(nums, target);
        if(answer == -1){
            answer = insertBinarySearch(nums,target);
        }
        return answer;
    }
    // 해당되는 타겟값이 있으면 해당 인덱스 반환, 그렇지 않으면 -1 반환
    static int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start+end) / 2;
            if(nums[mid] < target){
                start = mid+1;
            }else if(nums[mid] > target){
                end = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    // 타겟의 끝지점을 찾는다. End점에는 결국에는 해당되는 값의 마지막지점 인덱스가 저장되어있다.
    static int insertBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start+end) / 2;
            if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end+1;
    }
}
