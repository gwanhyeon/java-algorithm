import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드_재귀 {
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int x = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = n-1;
            int res = BinarySearch(x,start,end);
            System.out.println(res);
            // none contain
            if(res != 0){
                answer.add(1);
            }else{
                answer.add(0);
            }
        }
        for (Integer value : answer) {

            System.out.print(value + " ");

        }
    }

    static int BinarySearch(int target, int start, int end) {

        if(start > end){
            return 0;
        }
        int mid = (start + end) / 2;

        if(arr[mid] < target){
            return BinarySearch(target, mid+1, end);
        }else if(arr[mid] > target){
            return BinarySearch(target, start, mid-1);
        }else {
            return 1;
        }
    }
}
