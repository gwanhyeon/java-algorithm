package hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Array2d {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        // 0 1 2 3 4 5
        // 0 1 2 3 4 5
        // 0 1 2 3 4 5
        // 0 1 2 3 4 5
        // 0 1 2 3 4 5
        // 0 1 2 3 4 5

        int answer = -64;
        for(int i=0; i<arr.size()-2; i++){
            for(int j=0; j<arr.get(i).size()-2; j++){
                int sum = 0;
                sum += arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2);
                sum += arr.get(i+1).get(j+1);
                sum += arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                answer = Math.max(answer, sum);
            }
        }
        return answer;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Array2d.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
