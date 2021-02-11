import java.util.ArrayList;

public class twosum {
    static ArrayList<Integer> answer;
    static ArrayList<String> a = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums= {3,2,4};
        boolean[] check = new boolean[1000001];
        int target = 6;
        answer = new ArrayList<>();
        dfs(0,0,0,check,nums,target);
        int[] value = new int[answer.size()];

        for(int i=0; i<answer.size(); i++){
            value[i] = answer.get(i);
        }

    }

    private static void dfs(int idx,int cnt,int sum, boolean[] check, int[] nums, int target) {

        if(sum == target && cnt == 2){
            for(int i=0; i<nums.length; i++){
                if(check[i]){
                    answer.add(i);
                }
            }
            return;
        }
        for(int i=idx; i<nums.length; i++){
            if(check[i]){
                continue;
            }
            check[i] = true;
            dfs(idx+i,cnt+1,sum+nums[i], check,nums,target);
            check[i] = false;

        }


    }
}
