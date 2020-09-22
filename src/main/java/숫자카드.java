import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 숫자카드 {

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

            // none contain
            if(BinarySearch(x,n) == -1){
                answer.add(0);
            }else {
                answer.add(1);
            }
        }

        for (Integer value : answer) {

            System.out.print(value + " ");

        }
    }

    static int BinarySearch(int target, int len) {

        int start = 0;
        int end = len-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] < target){
                start = mid+1;
            }else if(arr[mid] > target){
                end = mid-1;
            }else {
                return mid;
            }

        }
        return -1;
    }

}

    /* HashSet 문제
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> s = new HashSet<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            s.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());

            if(s.contains(num)){
                arr.add(1);
            }else {
                arr.add(0);
            }
        }

        for (Integer value : arr) {
            System.out.print(value + " ");

        }

    }
     */
//}
