import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 수정렬하기2_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();


        for(int i=1; i<n; i++){
            arr.add(Integer.parseInt(br.readLine()));

        }
        Collections.sort(arr);
        arr.forEach((value) -> {
            System.out.println(value);
        });

    }
}
